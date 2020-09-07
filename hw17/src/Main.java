import com.hillel.impl.VideoLibrary;

public class Main {

	public static void main(String[] args) throws Exception {
		VideoLibrary first=new VideoLibrary();
		first.findFilmThisOrPreviousYear().stream().forEach(System.out::println);
		System.out.println();
		first.findActorsByFilm("X-Men: Apocalypse").stream().forEach(System.out::println);
		System.out.println();
		first.findActorsWhoDirectorFilm().stream().forEach(System.out::println);
		System.out.println();
		first.findActorsByNorMoreFilms(2).stream().forEach(System.out::println);
		System.out.println();
//		first.deleteFilmThenRelaseYearLessNYears(15);		
	}
}
