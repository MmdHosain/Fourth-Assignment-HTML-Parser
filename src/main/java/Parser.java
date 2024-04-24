import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public static List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>();
        sortedByName.add(countries.getFirst());
        for (int i = 1;i<countries.size();i ++) {
            for (int k = 0; k < sortedByName.size(); k++) {
                if (countries.get(i).getName().compareTo(sortedByName.get(k).getName())<0){
                    sortedByName.add(k,countries.get(i));
                    k = sortedByName.size()+10;
                }
                if ( k+1 == sortedByName.size()){
                    sortedByName.add(countries.get(i));
                    k = sortedByName.size()+10;
                }
            }
        }
        for (int i = 0; i < sortedByName.size(); i++) {
            j.out(i +" " + sortedByName.get(i).getName(),1);
        }
        return  sortedByName;
    }

    public static List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>();
        sortedByPopulation.add(countries.getFirst());
        for (int i = 1;i<countries.size();i ++) {
            for (int k = 0; k < sortedByPopulation.size(); k++) {
                if (countries.get(i).getPopulation()>sortedByPopulation.get(k).getPopulation()){
                    sortedByPopulation.add(k,countries.get(i));
                    k = sortedByPopulation.size()+10;
                }
                if ( k+1 == sortedByPopulation.size()){
                    sortedByPopulation.add(countries.get(i));
                    k = sortedByPopulation.size()+10;
                }
            }
        }
//        for (int i = 0; i < sortedByPopulation.size(); i++) {
//            j.out(i +" " + sortedByPopulation.get(i).getName()+ sortedByPopulation.get(i).getPopulation(),1);
//        }
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>();
        sortedByArea.add(countries.getFirst());
        for (int i = 1;i<countries.size();i ++) {
            for (int k = 0; k < sortedByArea.size(); k++) {
                if (countries.get(i).getArea()>sortedByArea.get(k).getArea()){
                    sortedByArea.add(k,countries.get(i));
                    k = sortedByArea.size()+10;
                }
                if ( k+1 == sortedByArea.size()){
                    sortedByArea.add(countries.get(i));
                    k = sortedByArea.size()+10;
                }
            }
        }
        return sortedByArea;
    }

    public static void setUp() throws IOException {

        File htmlFile = new File("src/Resources/country-list.html");
        Document doc = Jsoup.parse(htmlFile, "UTF-8");
        Elements elementList =  doc.getElementsByClass("col-md-4 country");
        String countryName ;
        String countryCapital ;
        int countryPopulation ;
        double countryArea ;

        for (Element element:elementList){
            countryName = element.getElementsByClass("country-name").first().text();
            countryCapital = element.getElementsByClass("country-info").first().getElementsByClass("country-capital").text();
            countryPopulation = Integer.parseInt(element.getElementsByClass("country-info").first().getElementsByClass("country-population").text());
            countryArea = Double.parseDouble(element.getElementsByClass("country-info").first().getElementsByClass("country-area").text());
            countries.add(new Country(countryName,countryCapital,countryPopulation,countryArea));
        }
    }

    public static void main(String[] args) throws IOException {
        setUp();
        sortByName();
    }
}
