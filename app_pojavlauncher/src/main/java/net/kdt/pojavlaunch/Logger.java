
package net.kdt.pojavlaunch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.view.View;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class Logger
{

    private static final String LOGTAG = "Logger";

    // Set to false to remove creation of local file
    private static final boolean IS_DEBUG_MODE = true;

    private static final SimpleDateFormat mSDF = new SimpleDateFormat( "MM-dd hh:mm:ss.SSS" );

    public Logger() {

    }

    public static void d( String tag, String msg ) {
        Log.d( tag, msg );

        writeToFile( tag, msg );
    }

    public static void d( String tag, String msg, Throwable th ) {
        Log.d( tag, msg, th );

        writeToFile( tag, msg, th );
    }
    public static void e( String tag, String msg ) {
        Log.e( tag, msg );

        writeToFile( tag, msg );
    }

    public static void e( String tag, String msg, Throwable th ) {
        Log.e( tag, msg, th );

        writeToFile( tag, msg, th );
    }
    public static void i( String tag, String msg ) {
        Log.i( tag, msg );

        writeToFile( tag, msg );
    }

    public static void i( String tag, String msg, Throwable th ) {
        Log.i( tag, msg, th );

        writeToFile( tag, msg, th );
    }
    public static void v( String tag, String msg ) {
        Log.v( tag, msg );

        writeToFile( tag, msg );
    }

    public static void v( String tag, String msg, Throwable th ) {
        Log.v( tag, msg, th );

        writeToFile( tag, msg, th );
    }
    public static void w( String tag, String msg ) {
        Log.w( tag, msg );

        writeToFile( tag, msg );
    }

    public static void w( String tag, String msg, Throwable th ) {
        Log.w( tag, msg, th );

        writeToFile( tag, msg, th );
    }
    public static void w( String tag, Throwable th ) {
        Log.w( tag, th );

        writeToFile( tag, th );
    }
    public static void wtf( String tag, String msg ) {
        Log.wtf( tag, msg );

        writeToFile( tag, msg );
    }

    public static void wtf( String tag, String msg, Throwable th ) {
        Log.wtf( tag, msg, th );

        writeToFile( tag, msg, th );
    }
    public static void wtf( String tag, Throwable th ) {
        Log.wtf( tag, th );

        writeToFile( tag, th );
    }

    private static void writeToFile( String tag, String msg ) {

        if( IS_DEBUG_MODE ) {
            File root = Environment.getExternalStorageDirectory();
            File file = new File( root, "appLog.txt" );

            try {
                if( root.canWrite() ) {
                    FileWriter fileWriter = new FileWriter( file, true );
                    BufferedWriter out = new BufferedWriter( fileWriter );

                    Date d = new Date();

                    out.write( mSDF.format( d ) + ": " + tag + " : " + msg );
                    out.newLine();
                    out.close();
                }
            } catch( IOException e ) {
                Log.d( LOGTAG, "Couldn't write file: " + e.getMessage() );
                Toast.makeText(View.getContext(), "no log??", Toast.LENGTH_LONG).show();
            }
        }
    }

    private static void writeToFile( String tag, String msg, Throwable th ) {
        writeToFile( tag, msg + ", e: " + th.getMessage() );
    }

    private static void writeToFile( String tag, Throwable th ) {
        writeToFile( tag, th.getMessage() );
    }

}
