package company.HW;

import java.util.*;

public class HW_34 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            char[] str= sc.nextLine().toCharArray();
            Arrays.sort(str);
            List<Character> ls= new ArrayList<>();
            for(char c:str)
                ls.add(c);
            Collections.sort(ls, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if(Character.isDigit(o1)&&Character.isDigit(o2)){
                        return o1-o2;
                    }else if(!Character.isDigit(o1)&&Character.isDigit(o2)){
                        return 1;
                    }else if(Character.isDigit(o1)&&!Character.isDigit(o2)){
                        return -1;
                    }else{
                        if((o1>='A'&&o1<='Z'&&o2>='A'&&o2<='Z')
                                ||(o1>='a'&&o1<='z'&&o2>='a'&&o2<='z')){
                            return o1-o2;
                        }else if(o1>='A'&&o1<='Z'&&o2>='a'&&o2<='z') {
                            return -1;
                        }else if(o1>='a'&&o1<='z'&&o2>='A'&&o2<='Z'){
                            return 1;
                        }
                    }
                    return 0;
                }
            });
            String strs="";
            for(int i=0;i<ls.size();i++)
                strs+=ls.get(i);
            System.out.println(strs);
        }
        sc.close();
    }
}
