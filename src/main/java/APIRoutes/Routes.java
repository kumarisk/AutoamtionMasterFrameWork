package APIRoutes;

public class Routes {

    /*
    This class maintain all the URL's
                or
     We can create a class like this, or we can maintain all the URl's in config.properties file
     */


    public static String base_url = "https://petstore.swagger.io/v2/";

    //user apis

    public static String user_create_post = base_url+"user"; //to create single user
    //public static String user_arry_post = base_url+"user/createWithArray"; //to create list of users with array
    public static String user_logout_get = base_url+"{username}/logout"; // to logout the user
    public static String user_login_get = base_url+"user/login"; //to login to user
    public static String user_delete = base_url+"user/{username}"; //to delete user
    public static String user_update_put = base_url+"/user/{username}"; //to update user data
    public static String user_get = base_url+"user/{username}"; //to get user data
    //public static String user_list_post = base_url+"user/createWithList"; //to create list of users with list

    //Store apis

    public static String store_get = base_url+"store/inventory";  //return pet inventories by status
    public static String store_post = base_url+"store/order"; //to place an order
    public static String store_purchase_get = base_url+"store/order/{orderid}";  //find purchase order by id
    public static String store_delete = base_url+"store/order/{orderid}";  //delete order based on id


    //pet apis

    public static String add_pets = base_url+"pet"; //adding pet to store
    public static String upload_pet_image = base_url+"pet/{petId}/uploadImage"; //uploads an image
    public static String update_pet = base_url+"pet"; //updating an existing pet
    public static String find_pet_ByStatus = base_url+"pet/findByStatus"; //find pets by status
    public static String find_pet_ById = base_url+"pet/{petId}";  //find pet by id
    public static String update_pet_formData = base_url+"pet/{petId}"; //updates a pet with form data
    public static String delete_pet = base_url+"pet/{petId}"; //delete a pet by id

}
