${question.content}
package leetcode.editor.cn;

public class P${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        Solution solution = new P$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        // TO TEST
        System.out.println(solution);
    }
    ${question.code}
}

${question.content}
package main
import "fmt"

func main(){
    fmt.Println()
}
${question.code}

${question.content}ds
\#include<iostream>
\#include<algorithm>
\#include<vector>
using namespace std;

${question.code}
