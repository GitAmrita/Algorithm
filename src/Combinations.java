/**
 * Created by achowdhury on 6/4/2015.
 */
public class Combinations {
    private StringBuilder output = new StringBuilder();
    private final String inputstring ;
    public Combinations( final String str ) {
        inputstring = str;
        System.out.println("The input string  is  : " + inputstring);
    }

    public void combine() { combine( 0 ); }

    private void combine(int start ){
        for( int i = start; i < inputstring.length(); ++i ){
            output.append( inputstring.charAt(i) );
            System.out.println( output );
            if ( i < inputstring.length() )
                combine( i + 1);
            output.setLength( output.length() - 1 );
            System.out.println(output);
            System.out.println(i);
        }
    }
}
