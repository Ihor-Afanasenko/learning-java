import com.hillel.impl.VideoLibrary;

public class Main {

	public static void main(String[] args) throws Exception {
		VideoLibrary movies=new VideoLibrary();
		movies.findFilmThisOrPreviousYear().stream().forEach(System.out::println);
		System.out.println();
		movies.findActorsByFilm("X-Men: Apocalypse").stream().forEach(System.out::println);
		System.out.println();
		movies.findActorsWhoDirectorFilm().stream().forEach(System.out::println);
		System.out.println();
		movies.findActorsByNorMoreFilms(2).stream().forEach(System.out::println);
		System.out.println();
		System.out.println(movies.deleteFilmThenRelaseYearLessNYears(30));		
	}
}
