package pojos;

public class JPHPojo {
    /*
        Request Body
{
    “title”: “Ahmet”,
    “body”: “Merhaba”,
    “userId”: 10,
    “id”: 70
}
     */
/*
    1-Tüm Variable'lar private olarak oluşturulur
    2-Tüm variable'lar için getter() ve Setter() metotları oluştururlur
    3-Tüm variable'ları içeren parametreli bir constructor hazırlanır
    4-Default Constructor'a benzeyen bir constructor oluşturulur
    5-Sonuçları yazdırmak için toString() methodu kullanılır


 */
    //   1-Tüm Variable'lar private olarak oluşturulur
    private String title;
    private String body;
    private int userId;
    private int id;


    // 2-Tüm variable'lar için getter() ve Setter() metotları oluştururlur


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3-Tüm variable'ları içeren parametreli bir constructor hazırlanır

    public JPHPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4-Default Constructor'a benzeyen bir paramtresiz bir constructor oluşturulur

    public JPHPojo() {

    }



    //    5-Sonuçları yazdırmak için toString() methodu kullanılır


    @Override
    public String toString() {
        return "JPHPojo: \n{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}

