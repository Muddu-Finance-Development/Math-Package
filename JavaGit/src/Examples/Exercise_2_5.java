/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package Examples;
import FinApps.Intermstructure;
import FinApps.Spots;
import FinApps.Volatility;
import java.io.*;
import java.lang.*;
/**
 *
 * @author Muddu
 */
public class Exercise_2_5
{
    public Exercise_2_5()
    {
    }
    public static void main(String[] args)
    {
        Intermstructure i=new Intermstructure();
        Volatility vol=new Volatility(100.0,1);
        Spots s=new Spots();
        double[]vals={4.0,6.0};
        double dat02[][]={{1.0,2.12},{2.0,2.66},{3.0,3.06},{5.0,3.68},{7.0,4.10}};
        double[][]dat13={{1.0,1.97},{2.0,2.47},{3.0,2.85},{5.0,3.42},{7.0,3.85}};
        double[] reqdyield_02;
        double[] reqdyield_13;
        double[][]newdata;
        double[][]dat_02;
        double[][]dat_13;
        int frwd=2;
        dat_02=i.lagraninterp(dat02,vals);
        dat_13=i.lagraninterp(dat13,vals);
        try
        {
            File output = new File("/Users/Muddu/Documents/javaoutput.txt");
            File dir = output.getParentFile();
            if (!dir.isDirectory() && !dir.mkdirs())
            {
                // handle could not create directory
                throw new SomeException("Could not create target directory '" + dir + "'");
            }
            File output2 = new File("/Users/Muddu/Documents/data_for_02_5B.txt");
            File dir2 = output.getParentFile();
            if (!dir2.isDirectory() && !dir2.mkdirs())
            {
                // handle could not create directory
                throw new SomeException("Could not create target directory '" + dir + "'");
            }
            PrintWriter w=new PrintWriter(output2);
            System.out.println("Daily 02/08 Daily 13/08 ");
            System.out.println("MATURITY SPOT MATURITY SPOT");
            for(int j=0;j<dat_02.length;j++)
            {
                System.out.println(" "+formatter.format(dat_02[j][0])+" "+formatter.format(dat_02[j][1])+" "formatter,format(dat_13[j][0])+" "formatter.format(dat_13[j][1]));
                dat_02[j][1]=(dat_02[j][1]/100.0);
                dat_13[j][1]=(dat_13[j][1]/100.0);
            }
            System.out.println("MATURITY PAR YIELD(02/08) SPOT PAR YIELD(13/08) SPOT");
            reqdyield_02=s.parCoupon(dat_02);
            reqdyield_13=s.parCoupon(dat_13);
            
            for(int j=0;j<dat_13.length;j++)
            {
                System.out.println(" "+formatter.format((j+1))+" "+formatter.format(reqdyield_02[j])+" "+formatter.format(dat_02[j][1])+" "+formatter.format(reqdyield_13[j])+" "+formatter.format(dat_13[j][1]));
            }
            i.setCurrentRateData(dat_02);
            System.out.println("YIELD (02/08) DISCOUNT RATE (02/08) FORWARD RATE (02/08) ");
            for (int j=0;j<dat_02.length;j++)
            {
                System.out.print(formatter.format(dat_02[j][1])" "+formatter.format(i.getCurrentDiscOne((j+1))));
                pw.print((j+1)+","+dat_02[j][1]+","+((1.0-(i.getCurrentDiscOne(j+1))))+",");
                if(frwd<(dat_02.length+1))
                    {
                        System.out.println(" "+formatter.format(i.getCurrentForwardrateYlds((frwd-1),(frwd))));
                        pw.println(i.getCurrentForwardrateYlds((frwd-1),(frwd)));
                        frwd++;
                    }
            }
            System.out.println();
            frwd=2;
            i.setCurrentRateData(dat_13);
            System.out.println("YIELD (13/08) DISCOUNT RATE (13/08) FORWARD RATE (13/08) ");
            for (int j=0;j<dat_13.length;j++)
            {
                System.out.print(formatter.format(dat_13[j][1]+""+formatter.format(i.getCurrentDiscOne((j+1))));
                w.print((j+1)+","+dat_13[j][1]+","+((1.0-(i.getCurrentDiscOne(j+1))))+",");
                if(frwd<8)
                {
                    System.out.println(" "+formatter.format(i.getCurrentForwardrateYlds((frwd-1),(frwd))));
                    w.println(i.getCurrentForwardrateYlds((frwd-1),(frwd)));
                    frwd++;
                }
            }
            w.println(" ");
            pw.println(" ");
            pw.close();
            w.close();
        }
        catch(IOException foe)
        {
        System.out.println(foe);
        }
    }
}
