/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package FinApps;
/**
 *
 * @author Muddu
 */
public class PresentValue 
{
    /**Instance of the class**/
    public PresentValue()
    {
    }
    public double pV(double[] discounts,double[] cashflows)
    {
        double presval=0;
        for(int i=0;i<cashflows.length;i++)//returns sum of discounted values
        {
           presval+=discounts[i]*cashflows[i]; 
        }
        return presval;
    }
    public double pV(double r,double[] cashflows)//implements PV for given IR
    {
        int indx=1;
        double sum=0;
        for(int i=0;i<cashflows.length;i++)
        {
            sum+=(cashflows[i]/Math.pow((1+r),indx));
            indx++;
        }
        return sum;
    }
    public double pV(double r,double cash,int period)
    {
        double sum=0;
        int indx=1;
        for(int i=0;i<period;i++)
        {
            sum+=(cash/Math.pow(1+r,indx));
            indx++;
        }
        return sum;
    }
}
