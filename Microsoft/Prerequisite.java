class Solution {
    public boolean isPossible(int N, int prerequisites[][])
    {
        boolean visited[]=new boolean[N];
        boolean dfs_visited[]=new boolean[N];
    ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    for(int i=0;i<N;i++)
    {
        graph.add(new ArrayList<>());
    }
    for(int i=0;i<prerequisites.length;i++)
    {
        graph.get((prerequisites[i][1])).add(prerequisites[i][0]);
    }
    for(int i=0;i<N;i++)
    {
        if(visited[i])
        {
            continue;
        }
        visited[i]=true;
        if(have_cycle(i,graph,visited,dfs_visited))
        {
            return false;
        }
    }
    return true;
    }
    public static boolean have_cycle(int idx,ArrayList<ArrayList<Integer>> graph,boolean visited[],boolean dfs_visited[])
    {
      dfs_visited[idx]=true;
       for(int i:graph.get(idx))
       {
           if(!visited[i])
           {
               visited[i]=true;
         if(have_cycle(i,graph,visited,dfs_visited))
         {
             return true;
         }
           }
           else if(dfs_visited[i])
           {
               return true;
           }
       }
       dfs_visited[idx]=false;
       return false;
    }
}
