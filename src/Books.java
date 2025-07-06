import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Books {
    public List<String> authorData = new ArrayList<>();
    public List<Integer> pagesData = new ArrayList<>();
    public List<String> titlesData = new ArrayList<>();

    public void reader() {
        try (
                InputStreamReader authorStream = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("BookAuthors"));
                InputStreamReader pagesStream = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("BookPages"));
                InputStreamReader titlesStream = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("BookTitles"));
                BufferedReader authorReader = new BufferedReader(authorStream);
                BufferedReader pagesReader = new BufferedReader(pagesStream);
                BufferedReader titlesReader = new BufferedReader(titlesStream)
        ) {
            String authorLine, pagesLine, titleLine;
            while ((authorLine = authorReader.readLine()) != null &&
                    (pagesLine = pagesReader.readLine()) != null &&
                    (titleLine = titlesReader.readLine()) != null) {
                authorData.add(authorLine);
                pagesData.add(Integer.parseInt(pagesLine));
                titlesData.add(titleLine);
            }
        } catch (Exception e) {
            System.err.println("Error reading book data: " + e.getMessage());
        }
    }
}
