package main;

import java.util.Random;
import java.text.DecimalFormat;

public class Main
{
    public static void main( String[] args )
    {
        int maxValue = 100, length = 100000000;
        
        //int[] array = initSortedMass( length , maxValue , true );
        //int[] array = initSortedMass( length , maxValue , false ); //reverse-order
        int[] array = initRandomMass( length , maxValue );
        
        long start = System.currentTimeMillis();
        MergeSort( array );
        long now = System.currentTimeMillis();
        
        print( array ); //works with length <20
        showStatistic( now - start , array , maxValue );
    }
    
    public static void showStatistic( long millisecond , int[] array , int maxValue )
    {
        System.out.printf( "%n[%s - length]  [%s - max value]\nIn %s ms. (in %s seconds) finished" ,
                           customFormat( "###,###,###,###" , array.length ) ,
                           customFormat( "###,###,###,###" , maxValue ) , millisecond ,
                           ( millisecond ) / 1000.0 );
    }
    
    public static void print( int[] array )
    {
        if ( array.length < 20 )
        {
            for ( int a : array )
            {
                System.out.print( a + "\t" );
            }
        }
        else System.out.println();
    }
    
    static public String customFormat( String pattern , double value )
    {
        try
        {
            DecimalFormat myFormatter = new DecimalFormat( pattern );
            pattern = myFormatter.format( value );
        }
        catch ( Exception e )
        {
            
            //ignore..
        }
        return pattern;
    }
    
    public static int[] initRandomMass( int length , int maxElementValue )
    {
        int[] array = new int[ length ];
        Random rnd = new Random();
        for ( int i = 0 ; i < array.length ; i++ ) array[ i ] = rnd.nextInt( maxElementValue );
        
        return array;
    }
    
    public static int[] initSortedMass( int length , int maxElementValue , boolean asc )
    {
        int[] array = new int[ length ];
        int coeficient = Integer.max( length , maxElementValue ) / Integer.min( length ,
                                                                                maxElementValue ) + 1;
        if ( asc )
        {
            int nowValue = 0, tmpCountOfSames = 1;
            for ( int i = 0 ; i < array.length ; i++ )
            {
                array[ i ] = tmpCountOfSames++ % coeficient == 0 ? nowValue : nowValue++;
            }
        }
        else
        {
            int nowValue = maxElementValue, tmpCountOfSames = 1;
            for ( int i = 0 ; i < array.length ; i++ )
            {
                array[ i ] = tmpCountOfSames++ % coeficient == 0 ? nowValue : nowValue--;
            }
        }
        
        return array;
    }
    
    public static void MergeSort( int[] array )
    {
        int[] tmpMass = array.clone();
        int mid,//Max length of lefts
                r_end,//Max length of rights
                len = array.length,//length of array
                left,//left side pointer
                right,//right side pointer
                counter;//counter of accepted (sorted) elements
        
        for ( int i = 1 ; i <= len ; i *= 2 )
        {
            for ( int startLeft = 0 ; startLeft + i <= len ; startLeft += i * 2 )
            {
                mid = startLeft + i;
                r_end = mid + i;
                if ( r_end > len ) r_end = len;
                left = counter = startLeft;
                right = mid;
                
                while ( left < mid && right < r_end ) //while we in left and right sides
                {
                    if ( array[ left ] <= array[ right ] )
                    {
                        tmpMass[ counter++ ] = array[ left++ ];
                    }
                    else
                    {
                        tmpMass[ counter++ ] = array[ right++ ];
                    }
                }
                
                while ( left < mid ) //finishing left side
                {
                    tmpMass[ counter++ ] = array[ left++ ];
                }
                
                while ( right < r_end ) //finishing right side
                {
                    tmpMass[ counter++ ] = array[ right++ ];
                }
            }
            
            for ( counter = 0; counter < len ; counter++ )
            {
                array[ counter ] = tmpMass[ counter ];
            }
            //System.arraycopy( tmpMass , 0 , array , 0 , len );
        }
    }
}