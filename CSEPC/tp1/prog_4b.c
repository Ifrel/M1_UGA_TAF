#include <string.h>
#include <stdio.h>
#include <stdlib.h>

char *concat(char *str1, char *str2){
  char *buf = malloc(strlen(str1) + strlen(str2)+1);

  strncpy(buf, str1, strlen(str1));
  strncpy(buf+strlen(str1), str2, strlen(str2));
  *(buf+strlen(str1)+strlen(str2))='\0';
    
  return buf;
}

int main(){
    char* H ="hello";
    char* W="world";
  char *str = concat(H, W);
  printf("RESULT : %s\n", str); 

  return 0; 
}
