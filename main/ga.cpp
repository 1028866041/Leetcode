#include <iostream>
#include <random>
#include <vector>
#include <iostream>
#include <cmath>
#include <ctime>
#include <cstdlib>
#include <bitset>
#include <iomanip>

using namespace std;

constexpr double PI = 3.141592653589793;
constexpr int poSize = 50;           //种群规模
constexpr int evAlger = 500;         //进化迭代次数
constexpr double ovProbable = 0.850; //交叉概率
constexpr double vaProbable = 0.050; //变异概率
constexpr int deVar = 2;             //自变量
constexpr int length = 24;           //24位encode
constexpr int length2 = 23;          //23位encode
//遗传算法
class Range
{
public:
    Range(double mLower, double mUpper);
    double GetUpper() const;
    double GetLower() const;

private:
    double upper; //变量上限
    double lower; //变量下限
};

class Individual
{
public:
    Individual(double *var);
    double *GetVar();
    void ChaFitness(double);
    void ChaReFitness(double);
    void ChaSumFitness(double);
    double GetFitness();
    double GetReFitness();
    double GetSumFitness();

private:
    double var[deVar];
    double fitness;    //个体适应值
    double reFitness;  //适应概率
    double sumFitness; //累加概率准备轮转
};

void Initialize(); //初始化种群
void CaclFitness();
void CaclReFitness();
void CaclSumFitness();
void Select();    //选择种群
double Srand();   //随机数
void Crossing();  //杂交
void Variating(); //变异
void GeneticAlgorithm();

const Range range[deVar] = {Range(-3.0, 12.1), Range(4.1, 5.8)};
vector<Individual> nowPop;  //P(t)
vector<Individual> midPop;  //中间种群
vector<Individual> nextPop; //P(t+1)种群

Range::Range(double mLower, double mUpper) : lower(mLower), upper(mUpper) {}
double Range::GetUpper() const
{
    return upper;
}

double Range::GetLower() const
{
    return lower;
}

Individual::Individual(double *mVar)
{
    for (int i = 0; i < deVar; i++)
    {
        if ((mVar[i] > range[i].GetLower()) && (mVar[i] <= range[i].GetUpper()))
        {
            var[i] = mVar[i];
        }
        else
        {
            cerr << "para error" << endl;
        }
    }
    this->fitness = 0;
    this->reFitness = 0;
    this->sumFitness = 0;
}

double *Individual::GetVar()
{
    return var;
}

double Individual::GetFitness()
{
    return this->fitness;
}

double Individual::GetReFitness()
{
    return this->reFitness;
}

double Individual::GetSumFitness()
{
    return this->sumFitness;
}

void Individual::ChaFitness(double fitness)
{
    this->fitness = fitness;
}

void Individual::ChaReFitness(double reFitness)
{
    this->reFitness = reFitness;
}

void Individual::ChaSumFitness(double sumFitness)
{
    this->sumFitness = sumFitness;
}

void Initialize()
{
    double X[poSize][deVar];
    //产生指定范围基因
    for (int j = 0; j < deVar; j++)
    {
        default_random_engine e(time(0)); //随机序列引擎
        uniform_real_distribution<double> u(range[j].GetLower(), range[j].GetUpper());
        for (int i = 0; i < poSize; i++)
        {
            X[i][j] = u(e);
        }
    }
    //生成染色体对象放入种群
    for (int i = 0; i < poSize; i++)
    {
        double var[deVar];
        for (int j = 0; j < deVar; j++)
        {
            var[j] = X[i][j];
        }
        Individual indiv(var);
        nowPop.push_back(indiv);
    }
}

void CalcFitness() //计算个体适应值
{
    double fitness = 0;
    double x[deVar];
    for (int i = 0; i < poSize; i++)
    {
        for (int j = 0; j < deVar; j++)
        {
            x[j] = nowPop[i].GetVar()[j];
        }
        fitness = 21.5 + x[0] * sin(4 * PI * x[0]) + 2 * sin(20 * PI * x[1]); //计算适应度
        nowPop[i].ChaFitness(fitness);                                        //修改染色体适应值
    }
}

void CalcReFitness() //计算适应值概率
{
    double sum = 0;
    double temp = 0;
    for (int i = 0; i < poSize; i++)
    {
        sum += nowPop[i].GetFitness(); //计算适应值之和
    }
    for (int j = 0; j < poSize; j++)
    {
        temp = nowPop[j].GetFitness();
        nowPop[j].ChaReFitness(temp); //修改个体适应概率
    }
}

void CalcSumFitness() //计算累加个体概率
{
    double sum = 0;
    for (int k = 0; k < poSize; k++)
    {
        sum += nowPop[k].GetFitness();
        nowPop[k].ChaSumFitness(sum);
    }
}

void Select() //选择种群
{
    double array[poSize];
    default_random_engine e(time(0));
    uniform_real_distribution<double> u(0.0, 0.1);
    for (int i = 0; i < poSize; i++)
    {
        array[i] = u(e);
    }
    //轮转选择
    for (int j = 0; j < poSize; j++)
    {
        for (int i = 0; i < poSize; i++)
        {
            if (array[j] < nowPop[i - 1].GetSumFitness())
            {
                midPop.push_back(nowPop[i - 1]); //加入中间种群
            }
            if (array[j] >= nowPop[i - 1].GetSumFitness() && array[j] <= nowPop[i].GetFitness())
            {
                midPop.push_back(nowPop[i]);
            }
        }
    }
    nowPop.clear();
}

double Scand()
{
    return static_cast<double>(rand() % 999) / 1000.0;
}

void Crossing()
{
    int num = 0;
    double cross = 0.0;
    srand((unsigned)time(nullptr));
    double array[deVar], array2[deVar];
    while (num < poSize - 1)
    {
        cross = Scand();
        //判断是否需要杂交
        if (cross <= ovProbable)
        {
            for (int i = 0; i < deVar; i++)
            {
                array[i] = midPop[num].GetVar()[i];
                array2[i] = midPop[num + 1].GetVar()[i];
            }
            int local, local2;
            int cross[length], cross2[length2];
            double news[2], news2[2];
            bool p = true, p2 = true;
            for (int j = 0; j < deVar; j++)
            {
                if (j == 0)
                {
                    bitset<length> arrayb((array[j] + 3.0) * pow(10, 6));
                    bitset<length> array2b((array2[j] + 3.0) * pow(10, 6));
                    local = rand() % length;
                    //单点交叉交换parent基因
                    for (int k = 0; k < local; k++)
                    {
                        cross[k] = arrayb[k];
                    }
                    for (int k = 0; k < local; k++)
                    {
                        arrayb[k] = array2b[k];
                    }
                    for (int k = 0; k < local; k++)
                    {
                        array2b[k] = cross[k];
                    }
                    //x基因完成单点杂交
                    news[0] = double(arrayb.to_ulong()) / pow(10, 6) - 3.0;
                    news2[0] = double(array2b.to_ulong()) / pow(10, 6) - 3.0;
                    if (news[0] < range[0].GetLower() || news[0] > range[0].GetUpper() ||
                        news2[0] < range[0].GetLower() || news2[0] > range[0].GetUpper())
                    {
                        p = false;
                        break;
                    }
                }
                else if (j == 1)
                {
                    bitset<length2> arrayb2((array[j] * pow(10, 6)));
                    bitset<length2> array2b2((array2[j] * pow(10, 6)));
                    local = rand() % length2;
                    for (int k = 0; k < local2; k++)
                    {
                        cross2[k] = arrayb2[k];
                    }
                    for (int k = 0; k < local2; k++)
                    {
                        arrayb2[k] = array2b2[k];
                    }
                    for (int k = 0; k < local2; k++)
                    {
                        array2b2[k] = cross2[k];
                    }
                    //x2基因完成单点杂交
                    news[1] = double(arrayb2.to_ulong()) / pow(10, 6);
                    news2[1] = double(array2b2.to_ulong()) / pow(10, 6);
                    if (news[1] < range[1].GetLower() || news[1] > range[1].GetUpper())
                    {
                        p2 = false;
                        break;
                    }
                }
            }
            if ((p == true) && (p2 == true))
            {
                Individual child(news);
                Individual child2(news2);
                nextPop.push_back(child);
                nextPop.push_back(child2);
            }
            else
            {
                //遗传给下一代
                nextPop.push_back(midPop[num]);
                nextPop.push_back(midPop[num]);
            }
        }
        else
        {
            nextPop.push_back(midPop[num]);
            nextPop.push_back(midPop[num]);
        }
        num += 2;
    }
    midPop.clear();
}

void Variating()
{
    int num = 0;
    while (num < poSize)
    {
        double variation = Scand();
        if (variation <= vaProbable)
        {
            double x[2];
            bool p = true;
            int x1local, x2local;
            x[0] = nextPop[num].GetVar()[0];
            x[1] = nextPop[num].GetVar()[1];
            bitset<length> array1((x[0] + 3.0) * pow(10, 6)); //x1 encode
            bitset<length2> array2(x[1] * pow(10, 6));        //x2 encode
            x1local = rand() % length;
            x2local = rand() % length2;
            array1.flip(x1local); //改变array local位的状态
            array2.flip(x2local);
            x[0] = double(array1.to_ullong()) / pow(10, 6) - 3.0;
            x[1] = double(array2.to_ullong()) / pow(10, 6);
            if (x[0] < range[0].GetLower() || x[0] > range[0].GetUpper() || x[1] < range[1].GetLower() || x[1] > range[1].GetUpper())
            {
                p = false;
            }
            if (!p)
            {
                nowPop.push_back(nextPop[num]);
            }
            else
            {
                Individual newchild(x);
                nowPop.push_back(newchild);
            }
        }
        else
        {
            nowPop.push_back(nextPop[num]);
        }
        num++;
    }
    nextPop.clear();
}

void GeneticAlgorithm()
{
    Initialize();
    for (int i = 0; i < evAlger; i++)
    {
        CalcFitness();
        CalcReFitness();
        CalcSumFitness();
        Select();
        Crossing();
        Variating();
    }
    CalcFitness();
    double maxFitness = nowPop[0].GetFitness();
    int id = 0;
    for (int k = 0; k < poSize; k++)
    {
        if (maxFitness < nowPop[k].GetFitness())
        {
            maxFitness = nowPop[k].GetFitness();
            id = k;
        }
    }
    // 进化迭代输出结果
    cout << "Fitness"
         << "x1" << setw(10) << "x2" << setw(15) << endl;
    for (int j = 0; j < poSize; j++)
    {
        cout << nowPop[j].GetVar()[0] << setw(10) << nowPop[j].GetVar()[1] << setw(10) << nowPop[j].GetFitness() << endl;
    }
    cout << "x1=" << nowPop[id].GetVar()[0] << " "
         << "x2=" << nowPop[id].GetVar()[1] << " max " << maxFitness << endl;
}