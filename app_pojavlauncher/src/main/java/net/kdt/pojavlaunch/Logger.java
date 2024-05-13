
package net.kdt.pojavlaunch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

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
            }
        }
    }

    private static void writeToFile( String tag, String msg, Throwable th ) {
        writeToFile( tag, msg + ", e: " + th.getMessage() );
    }

}
