import java.util.ArrayList;
import java.util.List;

public class LanguageList {
    private final List<String> languages = new ArrayList<>();

    public boolean isEmpty() {
    return languages.size() == 0 ;
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public void removeLanguage(String language) {
      languages.remove(language);
    }

    public String firstLanguage() {
        if(isEmpty()) {
            return "";
        } else {
            return languages.get(0);
        }
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        for(String lang: languages) {
            if (lang == language){
                return true;
            }
        }
        return false;
    }

    public boolean isExciting() {
       for (String lang: languages ) {
           if (lang == "Java" || lang == "Kotlin") {
               return true;
           }
       }
        return false;
    }
}
