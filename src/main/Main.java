package main;

import java.util.Random;
import java.text.DecimalFormat;

public class Main
{
    public static void main( String[] args )
    {
        int i = 3, maxValue = 10, length = 1000000;
        while ( i-- > 0 )
        {
            int[] mass = initSortedMass( length , maxValue , false );
            //int[] mass = initRandomMass( length , maxValue );
            print( mass ); //for small arrays using (<20 elem)
            
            long start = System.currentTimeMillis();
            MergeSort( mass );
            long now = System.currentTimeMillis();
            
            System.out.printf(
                    "%n[%s - length]  [%s - max value]\n======= finished ======= in %s ms. (in %s seconds)%n" ,
                    customFormat( "###,###,###,###" , mass.length ) ,
                    customFormat( "###,###,###,###" , maxValue ) , now - start ,
                    ( now - start ) / 1000.0 );
            
            maxValue *= 10000;
        }
    }
    
    public static void print( Object s )
    {
        System.out.print( s.toString() );
    }
    
    public static void print( int[] mass )
    {
        if ( mass.length < 20 )
        {
            for ( int a : mass )
            {
                print( a + "\t" );
            }
        }
    }
    
    static public String customFormat( String pattern , double value )
    {
        try
        {
            DecimalFormat myFormatter = new DecimalFormat( pattern );
            pattern = myFormatter.format( value );
        }
        finally
        {
            return pattern;
        }
    }
    
    public static int[] initRandomMass( int length , int maxElementValue )
    {
        int[] mass = new int[ length ];
        Random rnd = new Random();
        for ( int i = 0 ; i < mass.length ; i++ ) mass[ i ] = rnd.nextInt( maxElementValue );
        
        return mass;
    }
    
    public static int[] initSortedMass( int length , int maxElementValue , boolean asc )
    {
        int[] mass = new int[ length ];
        int coeficient = Integer.max( length , maxElementValue ) / Integer.min( length ,
                                                                                maxElementValue ) + 1;
        if ( asc )
        {
            int nowValue = 0, tmpCountOfSames = 1;
            for ( int i = 0 ; i < mass.length ; i++ )
            {
                mass[ i ] = tmpCountOfSames++ % coeficient == 0 ? nowValue : nowValue++;
            }
        }
        else
        {
            int nowValue = maxElementValue, tmpCountOfSames = 1;
            for ( int i = 0 ; i < mass.length ; i++ )
            {
                mass[ i ] = tmpCountOfSames++ % coeficient == 0 ? nowValue : nowValue--;
            }
        }
        
        return mass;
    }
    
    public static void MergeSort( int[] mass )
    {
        int[] tmpMass = mass.clone();
        int mid,//максимальная длина левой стороны
                r_end,//максимальная длина правой стороны
                len = mass.length,//просто длинна масива
                left,//указатель левого конца
                right,//указатель правого конца
                counter;
        
        for ( int i = 1 ; i <= len ; i *= 2 )
        {
            for ( int startLeft = 0 ; startLeft + i <= len ; startLeft += i * 2 )
            {
                mid = startLeft + i;
                r_end = mid + i;
                if ( r_end > len ) r_end = len;
                counter = startLeft;
                left = startLeft;
                right = mid;
                
                while ( left < mid && right < r_end ) //пока не вылезем за пределы стороны
                {
                    if ( mass[ left ] <= mass[ right ] )
                    {
                        tmpMass[ counter++ ] = mass[ left++ ];
                    }
                    else
                    {
                        tmpMass[ counter++ ] = mass[ right++ ];
                    }
                }
                
                while ( left < mid ) //добивка левой стороны
                {
                    tmpMass[ counter++ ] = mass[ left++ ];
                }
                
                while ( right < r_end ) //добивка правой стороны
                {
                    tmpMass[ counter++ ] = mass[ right++ ];
                }
            }
            
            for ( counter = 0; counter < len ; counter++ )
            {
                mass[ counter ] = tmpMass[ counter ];
            }
        }
    }
}