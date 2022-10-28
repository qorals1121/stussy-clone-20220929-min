class ImportApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ImportApi();
        }
        return this.#instance;
    }
    IMP = null;
    
    importPayParams = {
        pg: "kakaopay",
          pay_method: "card",
          merchant_uid: "product-" + new Date().getTime(),
          name: "노르웨이 회전 의자",
          amount: 1,
          buyer_email: "gildong@gmail.com",
          buyer_name: "홍길동",
          buyer_tel: "010-4242-4242",
          buyer_addr: "서울특별시 강남구 신사동",
          buyer_postcode: "01181"
    }
    impInfo = {
        impUid: null,
        restApiKey: null,
        restApiSecret: null
    }

    constructor() {
        this.IMP = window.IMP;
        this.impInfo.impUid = "imp1475140";
        this.impInfo.restApiKey = "2607153030333526";
        this.impInfo.restApiSecret = "P9qaD57bWL8oCrxDHUo0Zj7oRV4cEeyiHuz1pYQuZIOMO3XwLbzwAOltp4jVdvN7GYe8xZSKjIXeBujd";

        this.IMP.init(this.IMP.impInfo.impUid);
    }

    requestPay() {
        this.IMP.request_pay(this.importPayParams, this.responsePay);
    }

    responsePay(resp) {
        if(resp.success) {
            alert("결제 성공!");
            this.requestPayDetails();
        }else {
            alert("결제 실패!");
        }
    }

    requestImpAccessToken() {
        const accessToken = null;

        $.ajax({
            async: false,
            type: "post",
            url: "https://api.iamport.kr/users/getToken",
            contentType: "application/json",
            data: JSON.stringify({
                imp_key: this.impInfo.restApiKey,
                imp_secret: this.impInfo.restApiSecret
            }),
            dataType: "json",
            success: (response) => {
                accessToken = response;
            },
            error: (error) => {
                console.log(error);
            }
        });
        return accessToken;
    }

    requestPayDetail() {
        const accessToken = this.requestImpAccessToken();
        console.log(accessToken);
    }

}

class Oder {

    constructor() {
        this.addPaymentButtonEvent();
    }

    addPaymentButtonEvent() {
        const paymentButton = document.querySelector(".payment-button");
        paymentButton.onclick = () => {
            ImportApi.getInstance().requestPay();
        }
    }
}

window.onload = () => {
    new Oder();
}