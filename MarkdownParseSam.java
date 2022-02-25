import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseSam {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            for(int i = 0; i< toReturn.size(); i++){
                if(toReturn.get(i) == " "){
                    continue;
                }
                if(toReturn.get(i) == "!"){
                    return toReturn;
                }
            }
            
        }
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        /**int currentIndex = 0;
        int linkIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(openParen != -1 && closeParen != -1){
                String substring = markdown.substring(openParen+1, closeParen);
                if(!substring.contains(" ")){
                    if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket-1) != '!'){
                        toReturn.add(markdown.substring(openParen + 1, closeParen)); 
                        linkIndex++;
                    }
                    if(nextCloseBracket + 1 != openParen){
                        toReturn.remove(linkIndex-1);
                        linkIndex--;
                    }
                }
                 
            }
            
            if(closeParen == -1){
                break;
            }
            currentIndex = closeParen + 1;
        }
        */
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
