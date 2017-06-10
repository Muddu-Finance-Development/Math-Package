/*
 * Project developed for Financial Engineering Math package
 * Reference: Java methods for Financial engineering @Philip/ Barker
 */

package FinApps;
import static InterestRate.Intr.pvancert;
/**
 *
 * @author Muddu
 */
public class Volatility 
{
    public Volatility() 
    {
        this.facevalue=1000.0;
        this.frequency=2.0;
    }
    public Volatility(double parvalue,double coupontimes) 
    { 
        this.facevalue=parvalue;
        this.frequency=coupontimes;
    }
    private double mktprice;
    private double mktpricelow;
    private double mktpricenew;
    private double couponvalue;
    private double facevalue;
    private double frequency;
    private double pv;
    private double par;
    private double relativeprice;
    private double relativepricelow;
    private double upyield;
    private double downyield;
    private double newpriceup;
    private double newpricedown;
    private double currentyield;
    private double currentpvb;
    private void setInitialYldPp(double yield)
    {
        currentyield=yield;
    }
    public double getInitialPpYld()
    {
        return currentyield;
    }
    private void setPpointpriceup(double price)
    {
        newpriceup=price;
    }
    private void setPpointpricedown(double price)
    {
        newpricedown=price;
    }
    public double getPriceupPp()
    {
        return newpriceup;
    }
    public double getPricedownPp()
    {
        return newpricedown;
    }
    private void setdownyieldPp(double yield)
    {
        downyield=yield;
    }
    private void setupyieldPp(double yield)
    {
        upyield=yield;
    }
    public double getUpPp() 
    {
        return upyield;
    }
    public double getDownPp()
    {
        return downyield;
    }
    public double getValuePUp() 
    {
        return (Math.abs(getUpPp()-getInitialPpYld())/100.0);
    }
    public double getValuePDown()
    {
        return (Math.abs(getDownPp()-getInitialPpYld())/100.0);
    }
    private void setRelativeValue(double price)
    {
        relativeprice=price;
    }
    public double getRelativeValue()
    {
        return relativeprice;
    }
    private void setRelativeValuelow(double price)
    {
        relativepricelow=price;
    }
    public double getRelativeValuelow()
    {
        return relativepricelow; 
    }
    private void setCurrentPvb(double price)
    {
        currentpvb=price;
    }
    public double getCurrentPvb()
    {
        return currentpvb;
    }
    public void pVbPoints(double yield,double yearterm,double coupon,double pointchange)
    {
        double yieldval; 
        mktprice=Bpricing(yield,yearterm,coupon); 
        setCurrentPvb(mktprice); 
        yieldval=(yield+(pointchange/100.0));
        setRelativeValue(Math.abs(mktpricenew-mktprice));
        yieldval=(yield-(pointchange/100.0));// make basis point //adjustment lower
        mktpricelow=Bpricing(yieldval,yearterm,coupon);
        setRelativeValuelow(Math.abs(mktpricelow-mktprice));
    }
/* Provides basic bond pricing */
    private double Bpricing(double yield,double yearterm,double coupon)
    {
        couponvalue=((facevalue*coupon/100)/frequency);
        pv=(couponvalue*pvancert((yield/100.0)/frequency,(frequency*yearterm)));
        par=(facevalue*(1.0/Math.pow(1.0+(yield/100.0)/frequency,(frequency*yearterm))));
        return(pv+par);
    }
    public double percentVolatility(double yield,double yearterm,double coupon,double pointchange)
    {
        pVbPoints(yield,yearterm,coupon,pointchange);//price value of a
        //basis point couponvalue=((facevalue*coupon/100)/frequency);
        pv=(couponvalue*pvancert((yield/100.0)/frequency,(frequency*yearterm)));
        par=(facevalue*(1.0/Math.pow(1.0+(yield/100.0)/frequency,(frequency*yearterm))));
        mktprice=pv+par;
        return((getRelativeValue()/mktprice)*100.0);
    }
/**
*Method provides yield values for a percentage point
change in par value
*Sets via accessor methods the Yield value of a point change,
the initial yield value prior to applying the point change
     * @param couponpercent
     * @param price
     * @param maturity
     * @param estimate
     * @param pointvalue */
    public void yieldForPpoint(double couponpercent,double price, double maturity,double estimate,double pointvalue)
    {
        double couponterm=12.0/frequency;
        double change=((facevalue/100.0)*pointvalue);
        setPpointpricedown(price-change);
        setPpointpriceup(price+change);
        Tyield CalcBond= new Tyield();
    }
    setInitialYldPp(CalcBond.yieldEstimate(facevalue,couponterm,couponpercent,price,maturity,estimate));
    setdownyieldPp(abs((CalcBond.yieldEstimate(facevalue,couponterm,couponpercent,getPricedownPp(),maturity,estimate))));
    setupyieldPp(abs((CalcBond.yieldEstimate(facevalue,couponterm,couponpercent,getPriceupPp(),maturity,estimate))));
}
