package Pages;

import org.openqa.selenium.By;

public class FinalProjectPage {

    // 1
    public String pageUrl = "http://automationpractice.com/";
    public By signInTab= new By.ByCssSelector(".login");

    // 2
    public By emailAddressBox = new By.ByCssSelector("#email_create");
    public By createAccTab = new By.ByCssSelector("#SubmitCreate ");

    // 3


    public By personalInfo = new By.ByCssSelector("#account-creation_form");

    public By titleButton = new By.ByCssSelector("uniform-id_gender1");
    public By firstNameBox = new By.ByCssSelector("#customer_firstname");
    public By lastNameBox =  new By.ByCssSelector("#customer_lastname");
    public By passwordBox = new By.ByCssSelector("#passwd");

    public By dobDay = new By.ByCssSelector("#days option");
    public By dobMonth= new By.ByCssSelector("#months option");
    public By dobYear = new By.ByCssSelector("#years option");

    public By companyBox = new By.ByCssSelector("#company");

    public By addressBox = new By.ByCssSelector("#address1");
    public By cityBox = new By.ByCssSelector("#city");

    public By stateBox = new By.ByCssSelector("#id_state option");

    public By zipBox = new By.ByCssSelector("#postcode");
    public By homePhone = new By.ByCssSelector("#phone");

    public By mobilePhone= new By.ByCssSelector("#phone_mobile");

    // final register button  .click
    public By registerBtn= new By.ByCssSelector("#submitAccount ");

    public By myAccount = new By.ByCssSelector("#center_column h1");

    public By signOut = new By.ByCssSelector("#header div:nth-child(2) > a");

    // Test B
    public By email = new By.ByCssSelector("#email");

    public By password = new By.ByCssSelector("#passwd");

    public By signIn = new By.ByCssSelector("#SubmitLogin");


    // Test C

    public  By womanTab = new By.ByCssSelector("#block_top_menu > ul > li:nth-child(1) ");

    public By smallSize = new By.ByCssSelector("#layered_id_attribute_group_1");

    public  By products = new By.ByCssSelector(".ajax_block_product .product-name");

    public By addToCart = new By.ByCssSelector("#add_to_cart button ");

    public By layerCart = new By.ByCssSelector("#layer_cart div.clearfix ");

    public By quantity = new By.ByCssSelector("#layer_cart div.layer_cart_cart span.ajax_cart_product_txt");

    public By tops = new By.ByCssSelector("#layered_category_4");

    public By viewCart = new By.ByCssSelector("#header  div:nth-child(3) > div > a");

    public By total = new By.ByCssSelector("#total_price");

    public By proceedCheckout = new By.ByCssSelector(" p.cart_navigation.clearfix  a.button.btn.btn");

    public By proceedCheckout2 = new By.ByCssSelector("#center_column  form  button  span");

    public By proceedCheckout3 = new By.ByCssSelector("#form  p button  span");

    public By termsOfService = new By.ByCssSelector("#cgv");

    public By xButton = new By.ByCssSelector(".cross");

    public By logOut = new By.ByCssSelector(".logout");























}
