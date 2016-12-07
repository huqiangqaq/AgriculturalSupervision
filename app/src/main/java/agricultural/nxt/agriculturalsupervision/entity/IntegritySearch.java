package agricultural.nxt.agriculturalsupervision.entity;

/**
 * Created by huqiang on 2016/12/7 17:27.
 */

public class IntegritySearch {
    private int recodeNum;
    private int unitNum;
    private String productName;
    private String companyName;

    public IntegritySearch(int recodeNum, int unitNum, String productName, String companyName) {
        this.recodeNum = recodeNum;
        this.unitNum = unitNum;
        this.productName = productName;
        this.companyName = companyName;
    }

    public int getRecodeNum() {
        return recodeNum;
    }

    public void setRecodeNum(int recodeNum) {
        this.recodeNum = recodeNum;
    }

    public int getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(int unitNum) {
        this.unitNum = unitNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "IntegritySearch{" +
                "recodeNum=" + recodeNum +
                ", unitNum=" + unitNum +
                ", productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
