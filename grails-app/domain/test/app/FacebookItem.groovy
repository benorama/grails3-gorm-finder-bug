package test.app

class FacebookItem implements Item {

    static belongsTo = [account: FacebookAccount]

    FacebookAccount getAccount() {
      this.account
    }
    void setAccount(FacebookAccount account) {
      this.account = account
    }
    void setAccount(Account account) {
      this.account = account as FacebookAccount
    }

}
