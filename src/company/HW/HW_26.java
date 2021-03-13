package company.HW;

import java.util.*;

public class HW_26 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            char[] str= sc.nextLine().toCharArray();
            List<Character> ls=new ArrayList<>();
            for(char c:str){
                if(Character.isLetter(c))
                    ls.add(c);
            }
            Collections.sort(ls, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1)-Character.toLowerCase(o2);
                }
            });
            StringBuilder strs= new StringBuilder();
            int n=0;
            for(char c:str){
                if(Character.isLetter(c)&&n<ls.size()){
                    strs.append(ls.get(n));
                    n++;
                }else
                    strs.append(c);
            }
            System.out.println(strs.toString());
        }
        sc.close();
    }
}