package Gun09_Statu_ActionsClass.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Soru02 extends BaseDriver {
    // http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html
    // buradaki bütün öğrencileri bütün kutucukları doldurana kadar atınız.
    @Test
    public void Test1() {

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

         List<WebElement> students = driver.findElements(By.cssSelector("[id^='node']"));
        List<WebElement> teams = driver.findElements(By.cssSelector("[id='dhtmlgoodies_mainContainer'] div"));
        System.out.println("teams.size() = " + teams.size());




        Actions actions=new Actions(driver);

        for (WebElement s : students) {
            actions.clickAndHold(s).build().perform();
            MyFunc.Wait(1);
            for (WebElement t : teams) {
                if (!t.getText().contains(s.getText())){
                    actions.moveToElement(t).release().build().perform();
                    System.out.println(t.getText());}
                else break;

            }
        }



//        for (int i = 0; i < students.size(); i++) {
//            for (int j = 0; j < teams.size(); j++){
//                List<WebElement> list=driver.findElements(By.cssSelector("[id='"+teams.get(i).getAttribute("id")+"']>li"));
//                if (list.size()>0&&list.contains(students.get(i))){
//                    actions.clickAndHold(students.get(i)).build().perform();
//                    MyFunc.Wait(1);
//                    actions.moveToElement(teams.get(j+1)).release().build().perform();
//                    teams.remove(j);break;}



//
//        List<WebElement> students = driver.findElements(By.cssSelector("[id^='node']"));
//        List<WebElement> boxes = driver.findElements(By.cssSelector("[id^='box']"));


//        int counter = 0;
//        for (WebElement b : boxes) {
//            while (students.size() > 0) {
//                sendStudent(students.get(0), b, driver);
//                counter++;
//                students.remove(students.get(0));
//
//                if (b.getCssValue("height").contains("203") && counter == 7) {
//                    break;
//                } else if (b.getCssValue("height").contains("87") && counter == 3) {
//                    break;
//                } else if (b.getCssValue("height").contains("116") && counter == 4) {
//                    break;
//                }
//            }
//            counter = 0;
//        }
//        MyFunc.Wait(1);
    }


//    public static void sendStudent (WebElement student, WebElement boxes, WebDriver driver) {
//        Actions a = new Actions(driver);
//        a.clickAndHold(student).perform();
//        MyFunc.Wait(1);
//        a.moveToElement(boxes).release().perform();
//    }
    //Çözüm 2
    // List<WebElement> students = driver.findElements(By.cssSelector("#allItems>li"));
    //        List<WebElement> teams = driver.findElements(By.cssSelector("#dhtmlgoodies_mainContainer>div ul"));
    //
    //        Actions aksiyonlar = new Actions(driver);
    //
    //        for (WebElement t : teams) {
    //            String sayiHali = t.getCssValue("height");
    //            int yukseklik = Integer.parseInt(sayiHali.replaceAll("[^0-9]", ""));
    //
    //            while (yukseklik >= 29 && students.size() > 0) {
    //                aksiyonlar.clickAndHold(students.get(0)).perform();
    //                justWait(5);
    //                aksiyonlar.moveToElement(t).release().perform();
    //                students.remove(students.get(0));
    //                yukseklik = yukseklik - 29;
    //            }
    //        }




//        for (WebElement team : teams) {
//            for (int j = 0; j < students.size(); j++) {
//                WebElement student = students.get(0);
//                Actions actions = new Actions(driver);
//                actions.clickAndHold(student).build().perform();
//                MyFunc.Wait(1);
//                actions.moveToElement(team).build().perform();
//                MyFunc.Wait(1);
//                if (team.getAttribute("class").equalsIgnoreCase("mouseover")) {
//                    actions.release(student).build().perform();
//                    students.remove(student);
//                } else break;
//
//
//            }
//        }







//        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
//
//        List<WebElement> students=driver.findElements(By.cssSelector("[id^='node']"));
//        List<WebElement> classes=driver.findElements(By.cssSelector("[id^='box']"));
//
//        Actions actions=new Actions(driver);
//
//        for (int i = 0; i < students.size(); i++) {
//            for (int j = 0; j < classes.size(); j++){
//                List<WebElement> list=driver.findElements(By.cssSelector("[id='"+classes.get(i).getAttribute("id")+"']>li"));
//                if (list.size()>0&&list.contains(students.get(i))){
//                    actions.clickAndHold(students.get(i)).build().perform();
//                    MyFunc.Wait(1);
//                    actions.moveToElement(classes.get(j+1)).release().build().perform();
//                    classes.remove(j);break;}
//                else {
//                    actions.clickAndHold(students.get(i)).build().perform();
//                    MyFunc.Wait(1);
//                    actions.moveToElement(classes.get(j)).release().build().perform();break;}
//
//            }
//
//        }




//        for (WebElement f : classes)
//            System.out.println("f.getAttribute(\"id\") = " + f.getAttribute("id"));
//
//        actions.clickAndHold(students.get(0)).build().perform();
//        MyFunc.Wait(1);
//        actions.moveToElement(classes.get(3)).release().build().perform();
        
        

//        for (WebElement e : students){
//            for (WebElement j : classes){
//                if (j.getText().contains(e.getText())){
//                    classes.remove(j);
//                    actions.clickAndHold(e).build().perform();
//                    MyFunc.Wait(1);
//                    actions.moveToElement(j).release(j).build().perform();break;
//                }
//                else classes.remove(j);
//
//            }
//        }

//        for (WebElement student : students) {
//            for (int j = 0; j < classes.size(); j++){
//                if (classes.get(j).findElement(By.id("node1")).);
// //               if (classes.get(j).)
////                //List<WebElement> a=driver.findElements(By.cssSelector("#"+classes.get(j).getAttribute("id")+" li"));
////
////                if (!student.getAttribute("id").equals(driver.findElement(By.cssSelector("#"+classes.get(j).getAttribute("id")+">*:nth-last-child(1)")).getAttribute("id"))){
////                    MyFunc.Wait(1);
////                    actions.clickAndHold(student).build().perform();
////                    MyFunc.Wait(1);
////                    actions.moveToElement(classes.get(j)).perform();
////                    MyFunc.Wait(1);
////                    actions.release().build().perform();
//                    System.out.println("birinci çalıştı");
//
//                }
//            else {
//                    classes.remove(j);
//                    MyFunc.Wait(1);
//                    actions.clickAndHold(student).build().perform();
//                    MyFunc.Wait(1);
//                    actions.moveToElement(classes.get(j + 1)).perform();
//                    MyFunc.Wait(1);
//                    actions.release().build().perform();
//                    System.out.println("ikinci çalıştı");
//                    break;
//
//                }

//        }









}
