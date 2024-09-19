package tests;

import org.testng.annotations.Test;

public class ProfileTests extends TestBase{
    @Test
    public void changeProfilePositiveTest(){
        app.getHelperProfile().changeAvatar("photo.jpg");
    }
}
