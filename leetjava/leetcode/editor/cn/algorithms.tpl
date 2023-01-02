func bfs(root){
    queue.add(root);
    while(!queue.isEmpty()){
        n= queue.size();
        for(i=0;i<n;i++){
            node= queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }
}

func dfs(root){
    dfs(root.left);
    root.val;
    dfs(root.right);
}

func backtrack(num[], ls, idx){
	if(ls.size())
		return;
    /*all visited-subset idx*/
    visited[idx]=true;
	for(i=idx;i<num.length,i++){
		ls.add(num[i]);
		backtrack(num, ls, i+1);
		ls.remove(ls.size()-1);
	}
	visited[idx]= false;
	/*may convert to bfs/dfs*/
}

func dp(i){
    dp[0]=num[0];
    for(i=1;i<num.length;i++){
        dp[i]= func(dp[i-1],num[i]);
    }
}

func divide(n){
    func(divide(i), divide(n-i);
}

func graph(root[][]){
    bfs(idx){
        queue.offer(idx);
        visited[idx]=1;
        while(!queue.isEmpty()){
            node= queue.poll();
            for(i=0;i<root.length;i++){
                if(!visited[i]&&root[node-1][i]==1){
                    visited[i]=1;
                    queue.push(i);
                }
            }
        }
    }
    dfs(idx){
        visited[idx]=1;
        for(i=0;i<root.length;i++){
            if(!visited[i]&&root[idx-1][i]==1)
                dfs(i);
        }
    }
}

func avl(){
    search(root,key){
        if(root==null||root.val==key)
            return root;
        if(key<root.val)
            return search(root.left,key);
        if(root.val>key)
            reutrn search(root.right,key);
    }
}

func kmp(String s,t){
    i=0,j=-1;
    next[0]=-1;
    while(i<s.length()){
        if(j==-1||s.charAt(i)==s.charAt(j)){
            i++;
            j++;
            next[i]=j;
        }
        else
            j=next[j];
    }
    j=0;
    while(i<s.length()&&j<t.length()){
        if(j==-1||s.charAt(i)==t.charAt(i)){
            i++;
            j++;
        }else
            j=next[j];
    }
    return (j==t.length()?return i-j:-1;
}

class trie{
    trie[] next;
    boolbean end;
    trie fail; /*aho-corasick*/
    insert(s){
        cur=this;
        for(i=s.length()-1;i>=0;i--){
            j=s.charAt(i)-'a';
            if(cur.next[j]==null)
                cur.next[j]=new trie();
            cur=cur.next;
        }
        cur.end=true;
    }
    search(s){
        cur=this;
        for(i=0;i<s.length();i++){
            j=s.charAt(i)-'a';
            if(cur.next[j]==null)
                return false;
            cur=cur.next[j];
        }
        return cur.end;
    }
}

func redblack(){
    Stack<Node> stack;
    Queue<Node> queue;
    Map<Node,boolbean> map;
    redblack=true;
    boolbean isredblack(root){
        traverse(root);
        while(!stack.isEmpty()){
            node= stack.pop();
            if(node.left==null&&node.right==null){
                if(node.val>0)
                    map.put(node,1);
                else
                    map.put(node,0);
            }else{
                if(map.get(node.left)==map.get(node.right)){
                    flag=false;
                    if((node.left!=null&&node.val<0&&node.left.val<0)||
                        (node.right!=null&&node.val<0&&node.right.val<0))
                        flag=true;
                    if(flag)
                        redblack=false;
                        break;
                    if(node.val>0)
                        map.put(node, map.get(node.left)+1);
                    else
                        map.put(node, map.get(node.left));
                }else{
                    redbalck=false;
                    break;
                }
            }
        }
        return redblack;
    }
    traverse(root){
        queue.offer(root);
        while(!queue.isEmppty()){
            node=queue.poll();
            stack.push(node);
            if(node.left!=null)
                queue.push(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
    }
}

func toposort(root[][]){
    /*DAG to sort list*/
    for(node:root)
        for(node2:node )
            degree[node2]++;
    Queue<Integer> queue;
    for(i=0;i<root.length;i++)
        if(degree[i]==0)
            queue.offer(i);
    while(!queue.isEmpty()){
        node=queue.poll();
        res.add(node);
        for(node2:root[node]){
            if(--degree[]node2==0)
                queue.offer(node2);
        }
    }
    return res;
}

func dijkstra(num[][]){
     queue= new PriorityQueue<>((v1,v2));
     dist[0][0]=0;
     queue.add(int[]{0,0,0});
     while(!queue.isEmpty()){
        cur= queue.poll();
        if(visited[cur[0]][cur[1]])
            continue;
        visited[cur[0]][cur[1]]=true;
        for(d: dir[][]){
            nx= cur[0]+d[0];
            ny= cur[1]+d[1];
            if(nx<heights.length&&ny<heights[0].length){
                cost= Math.min(Math.max(dist[cur[0]][cur[1]],distance(cur[0],cur[1],nx,ny)), cost);
                queue.offer(nx,ny, cost);
            }
        }
     }
     return dist[heights.length-1][heights[0].length-1];
}

class dsu{
    int[] parent;
    find(x){
        if(x==parent(x))
            return x;
        return parent[x]=find(parent[x]);
    }
    merge(x,y){
        int xs=find(x),ys=find(y);
        if(xs!= ys){
            parent[xs]= ys;
        }
    }
}

func qsort(num[],start,end){
    i=start,j=end;
    while(i<j){
        while(i<j&&num[j]>num[start])
            j--;
        while(i<j&&num[i]<num[start])
            i++;
        if(num[i]==num[j]&&i<j)
            i++;
        else{
            tmp=num[i];
            num[i]=num[j];
            num[j]=tmp;
        }
        if(i>start+1)
            qsort(num,start,i-1);
        if(j<end-1)
            qsort(num,j+1,end);
    }
}

func search(num[], target){
    l=0,r=nums.length-1;
    while(l<=r){
        mid=(r-1)/2+l;
        if(num[mid]==target)
            break;
        if(num[mid]<target){
            l=mid+1;
        }else{
            r=mid/2;
        }
    }
}

func window(num[]){
    j=0;
    for(i=0;i<num.length;i++)
        while(j<num.length)
           j++;
    return max(j-i);
}

func memory(){
    boolbean[] mem;
    recurse(mem, n){
        func(recurse(i), recurse(n-i);
    }
}

GeneticAlgorithm(){
    调用调度生成算法N次并将生成的符号串存入Group;
	Do
	{
		计算Group中每个符号串的适应度值;
		调用繁殖算法;
		令BESTSIRING为Group中适应值最大的符号串;
		For(i=1 ; i<=GroupNum/2; i++)
		{
			从Group中取出两个符号串并以概率P¬1调用交叉操作;
			if(交叉操作发生)
				将生成的符号串加入Temp;
			else
				将原符号串加入Temp;
		}
		对Temp中的每一个符号串，以概率P2调用突变算法;
		if(突变操作发生)
			将新生成的符号串加入NewGroup;
		else
			将原符号串加入NewGroup;
			用BESTSIRNG取代Group中适应度值最小的符号串;
	}
	while(算法尚未满足收敛准则);
}

public class Main {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        sc.close();
    }
}

int main()
{
	int i;
    while(cin >> i){
    	cout<< i << endl;
	}
    return 0;
}