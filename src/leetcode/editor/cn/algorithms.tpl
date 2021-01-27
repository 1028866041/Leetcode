func bfs(root){
    queue.add(root);
    while(queue!=null){
        n= queue.size();
        for(i=0;i<n;i++){
            node= queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
            node.val;
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
    //visited[idx]=true;
	for(i=idx;i<num.length,i++){
		ls.add(num[i]);
		backtrack(num, ls, i);
		ls.remove(ls.size()-1);
	}
	//visited[idx]= false;
}

func traverse(graph){

}

func redblack(root){

}

func dp(i){
    dp[0]=num[0];
    for(i=1;i<num.length;i++){
        dp[i]= func(dp[i-1],num[i]);
    }
}

func divide(n){
    return func(divide(i), divide(n-i);
}

class trie{
    trie[] next;
    boolbean end;

    insert(s){

    }
    search(s){

    }
}

func dijkstra(num[][]){
     queue= new PriorityQueue<>((v1,v2));
     dist[0][0]=0;

     queue.add(new int[]{0,0,0});
     while(!queue.isEmpty()){
        cur= queue.poll();
        if(visited[cur[0]][cur[1]])
            continue;
        visited[cur[0]][cur[1]]=true;
        for(d: dir[][]){
            nx= cur[0]+d[0];
            ny= cur[1]+d[1];
            if(nx<heights.length&&ny<heights[0].length){
                cost= Math.min(Math.max(dist[cur[0]][cur[0]],distance(cur[0],cur[1],nx,ny)), cost);
                queue.offer(nx,ny, cost);
            }
        }
     }
     return dist[heights.length-1][heights[0].length-1];
}

func qsort(num[]){

}

func toposort(){

}

func search(num[], target){
    l=0,r=nums.length-1;
    while(l<=r){
        mid=(l+r)/2;
        if(num[mid]==target){
            break;
        }
        if(num[mid]<target){
            l=mid+1;
        }else{
            r=mid/2;
        }
    }
}

func window(num[]){
    j=0;
    for(i=0;i<num.length;i++){
        while(j<num.length){
           j++;
        }
    }
    return max(j-i);
}