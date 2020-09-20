import java.util.Arrays;
class app {
  public static void main(String[] args) {
  
    String[] words = {
      "coco",
      "coco",
      "pedro",
      "jean",
      "michel",
      "bertrand",
      "jaco",
      "edward",
      "zoe",
    };
  
    String [] newwords = {
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",

    };
    String test = "";
   
    for (int i = 0; i < words.length; i++) {

      for (int j = 0; j < newwords.length; j++) {
          if (words[i] ==  newwords[j]) {
              test = "erreur";
          }
      }
      if (test != "erreur") {
        newwords[i] = words[i];
      }
      test = "";
  }

    Arrays.sort(newwords);
    System.out.println(Arrays.toString(newwords)); 
    
        
      }
  }
