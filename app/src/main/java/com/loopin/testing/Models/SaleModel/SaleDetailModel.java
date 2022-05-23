package com.loopin.testing.Models.SaleModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SaleDetailModel {


    @SerializedName("BRAND_NAME")
    @Expose
    private String brandName;
    @SerializedName("SHOP_NAME")
    @Expose
    private String shopName;
    @SerializedName("SIZE")
    @Expose
    private Integer size;
    @SerializedName("TYPE")
    @Expose
    private String type;
    @SerializedName("CATEGORY")
    @Expose
    private String category;
    @SerializedName("QTY")
    @Expose
    private Integer qty;
    @SerializedName("MRP")
    @Expose
    private String mrp;
    @SerializedName("TOTAL_MRP_AMOUNT")
    @Expose
    private Integer totalMrpAmount;

    public SaleDetailModel(String shopName, String brandName, Integer size, String type, String category,
                           Integer qty, String mrp, Integer totalMrpAmount) {
        this.brandName = brandName;
        this.shopName = shopName;
        this.size = size;
        this.type = type;
        this.category = category;
        this.qty = qty;
        this.mrp = mrp;
        this.totalMrpAmount = totalMrpAmount;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public Integer getTotalMrpAmount() {
        return totalMrpAmount;
    }

    public void setTotalMrpAmount(Integer totalMrpAmount) {
        this.totalMrpAmount = totalMrpAmount;
    }

    public class Reponse{
        @SerializedName("SALE_DETAIL_REPORT")
        @Expose
        private List<SaleDetailModel> saleDetailReport = null;
        @SerializedName("TOTAL_QTY")
        @Expose
        private Integer totalQty;
        @SerializedName("TOTAL_AMOUT")
        @Expose
        private Integer totalAmout;
        @SerializedName("msg")
        @Expose
        private String msg;
        @SerializedName("error")
        @Expose
        private String error;

        public List<SaleDetailModel> getSaleDetailReport() {
            return saleDetailReport;
        }

        public void setSaleDetailReport(List<SaleDetailModel> saleDetailReport) {
            this.saleDetailReport = saleDetailReport;
        }

        public Integer getTotalQty() {
            return totalQty;
        }

        public void setTotalQty(Integer totalQty) {
            this.totalQty = totalQty;
        }

        public Integer getTotalAmout() {
            return totalAmout;
        }

        public void setTotalAmout(Integer totalAmout) {
            this.totalAmout = totalAmout;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
