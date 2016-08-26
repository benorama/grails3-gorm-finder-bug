package test.app

class FacebookItem implements Item {

    static belongsTo = [account: FacebookAccount]

    void setAccount(Account account) {
      this.account = account as FacebookAccount
    }
}
