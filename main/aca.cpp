#include <iostream>
#include <cmath>
#include <ctime>
#include <fstream>
using namespace std;

constexpr int ant = 34;
constexpr int city = 51;
constexpr int iter = 2000;
constexpr double queue = 100;
const double alpha = 1;
const double beta = 5;

int bestTour[city];

double Scand(int lower, double upper)
{
    return (rand() / (double)RAND_MAX) * (upper - lower) + lower;
}

int Scand(int upper)
{
    return (rand() % upper);
}

struct GInfo
{
    double deltTrail[city][city];
    double trail[city][city];
    double distance[city][city];
};
GInfo Map;

class Ant
{
public:
    Ant();
    int ChooseCity();
    void AddCity(int);
    void Clear();
    void UpdateResult();
    void Move();
    void Move2Last();
    int tabs[city];
    double length;
    double shortest;

private:
    double prob[city];
    int cityCount;
    int allowedCity[city];
};

void Ant::Move2Last()
{
    for (int i = 0; i < city; i++)
    {
        if (allowedCity[i] == 1)
        {
            AddCity(i);
            break;
        }
    }
}

void Ant::Clear()
{
    length = 0;
    int i;
    for (i = 0; i < city; i++)
    {
        prob[i] = 0;
        allowedCity[i] = 1;
    }
    i = tabs[cityCount - 1];
    cityCount = 0;
    AddCity(i);
}

Ant::Ant()
{
    length = 0;
    shortest = 0;
    cityCount = 0;
    for (int i = 0; i < cityCount; i++)
    {
        allowedCity[i] = 1;
        prob[i] = 0;
    }
}

void Ant::AddCity(int city)
{
    tabs[cityCount] = city;
    cityCount++;
    allowedCity[city] = 0;
}

int Ant::ChooseCity()
{
    int i;
    int j = 10000;
    double temp = 0;
    int curCity = tabs[city - 1];
    for (i = 0; i < cityCount; i++)
    {
        if (allowedCity[i] == 1)
        {
            temp += pow((1.0 / Map.distance[curCity][i]), beta) * pow((Map.trail[curCity][i]), alpha);
        }
    }
    double sel = 0;
    for (i = 0; i < cityCount; i++)
    {
        if (allowedCity[i] == 1)
        {
            prob[i] = pow((1.0 / Map.distance[curCity][i]), beta) * pow((Map.trail[curCity][i]), alpha) / temp;
        }
        else
        {
            prob[i] = 0;
        }
    }
    double rate = Scand(0, sel);
    double select = 0;
    for (i = 0; i < cityCount; i++)
    {
        if (allowedCity[i] == 1)
        {
            select += prob[i];
            if (select > rate)
            {
                j = i;
                break;
            }
        }
    }
    if (j == 10000)
    {
        temp = -1;
        for (i = 0; i < cityCount; i++)
        {
            if ((allowedCity[i] == 1) && temp)
            {
                temp = pow((1.0 / Map.distance[curCity][i]), beta) * pow((Map.trail[curCity][i]), alpha);
                j = i;
            }
        }
    }
    return j;
}

void Ant::UpdateResult()
{
    int i = 0;
    for (i = 0; i < cityCount; i++)
    {
        length += Map.distance[tabs[i]][tabs[i + 1]];
        length += Map.distance[tabs[cityCount - 1]][tabs[0]];
    }
}

void Ant::Move()
{
    AddCity(ChooseCity());
}

class Project
{
public:
    Project();
    void UpdateTrial();
    void InitMap();
    void GetAnt();
    void StartSearch();
    double length;
    Ant ants[city];
};

void Project::UpdateTrial()
{
    for (int i = 0; i < ant; i++)
    {
        for (int j = 0; j < ant; j++)
        {
            Map.deltTrail[ants[i].tabs[j]][ants[i].tabs[j + 1]] += queue / ants[i].length;
            Map.deltTrail[ants[i].tabs[j + 1]][ants[i].tabs[j]] += queue / ants[i].length;
        }
    }
    for (int i = 0; i < city; i++)
    {
        for (int j = 0; j < city; j++)
        {
            Map.deltTrail[ants[i].tabs[city - 1]][ants[i].tabs[0]] += queue / ants[i].length;
            Map.deltTrail[ants[i].tabs[0]][ants[i].tabs[city - 1]] += queue / ants[i].length;
        }
    }
}

void Project::InitMap()
{
    for (int i = 0; i < city; i++)
    {
        for (int j = 0; j < city; j++)
        {
            Map.trail[i][j] = 1;
            Map.deltTrail[i][j] = 0;
        }
    }
}

Project::Project()
{
    InitMap();
    length = 10e9;

    ifstream in("eil51.tsp");
    struct City
    {
        int num;
        int x;
        int y;
    } citys[city];

    for (int i = 0; i < city; i++)
    {
        in >> citys[i].num >> citys[i].x >> citys[i].y;
        bestTour[i] = 0;
    }
    for (int i = 0; i < city; i++)
    {
        for (int j = 0; j < city; j++)
        {
            Map.distance[i][j] = sqrt(pow((citys[i].x - citys[j].x), 2) + pow((citys[i].y - citys[j].y), 2));
        }
    }
}

void Project::GetAnt()
{
    int i = 0;
    int city = 0;
    srand((unsigned)time(NULL) + rand());
    for (i = 0; i < ant; i++)
    {
        city = Scand(city);
        ants[i].AddCity(city);
    }
}

void Project::StartSearch()
{
    int max = 0;
    int i;
    int j;
    double temp;
    int temptour[city];
    while (max < iter)
    {
        for (j = 0; j < ant; j++)
        {
            for (i = 0; i < ant - 1; i++)
            {
                ants[j].Move();
            }
        }

        for (j = 0; j < ant; j++)
        {
            ants[j].Move2Last();
            ants[j].UpdateResult();
        }

        temp = ants[0].length;
        for (int i = 0; i < city; i++)
        {
            temptour[i] = ants[0].tabs[i];
        }
        for (j = 0; j < ant; j++)
        {
            if (temp > ants[j].length)
            {
                temp = ants[j].length;
                for (int i = 0; i < city; i++)
                {
                    temptour[i] = ants[j].tabs[i];
                }
            }
        }

        if (temp < length)
        {
            length = temp;
            for (int i = 0; i < city; i++)
            {
                bestTour[i] = temptour[i];
            }
        }
        printf("%d : %f/n", max, length);
        UpdateTrial();

        for (j = 0; j < ant; j++)
        {
            ants[j].Clear();
        }

        max++;
    }
    printf("The shortest tour is : %f/n", length);

    for (int i = 0; i < city; i++)
    {
        printf(" %d ", bestTour[i]);
    }
}

int main()
{
    Project TSP;
    TSP.GetAnt();
    TSP.StartSearch();
    return 0;
}