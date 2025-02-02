package com.zipcodewilmington.froilansfarm.Vehicles;

import com.sun.source.tree.AssertTree;
import com.zipcodewilmington.froilansfarm.Animals.Farmer;
import com.zipcodewilmington.froilansfarm.Animals.Pilot;
import com.zipcodewilmington.froilansfarm.CropRow;
import com.zipcodewilmington.froilansfarm.Farm;
import com.zipcodewilmington.froilansfarm.Food.Corn;
import com.zipcodewilmington.froilansfarm.Food.CornStalk;
import com.zipcodewilmington.froilansfarm.Food.Crop;
import com.zipcodewilmington.froilansfarm.Food.TomatoPlant;
import com.zipcodewilmington.froilansfarm.Interfaces.Aircraft;
import com.zipcodewilmington.froilansfarm.Interfaces.FarmVehicle;
import com.zipcodewilmington.froilansfarm.Interfaces.Produce;
import com.zipcodewilmington.froilansfarm.Interfaces.Rider;
import org.junit.Assert;
import org.junit.Test;



public class CropDusterTest {
    CropDuster cropDuster = new CropDuster();

    @Test
    public void testInheritance() {

        Assert.assertTrue(cropDuster instanceof FarmVehicle);
    }

    @Test
    public void testInheritance2() {

        Assert.assertFalse(cropDuster instanceof Produce);
    }

    @Test
    public void testImplementation() {

        Assert.assertTrue(cropDuster instanceof Aircraft);
    }

    @Test
    public void testFly() {
        Pilot pilot = new Pilot();

        Assert.assertTrue(cropDuster.fly(pilot));
    }

    @Test
    public void testMakeNoise() {
        String expected = "roar roar roar";
        String actual = cropDuster.makeNoise();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMakeNoise2() {
        String expected = "buzz buzz buzz";
        String actual = cropDuster.makeNoise();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void testOperate() {
        Farm farm = new Farm();

        Assert.assertTrue(cropDuster.operate(farm));
    }

    @Test
    public void testOperate2() {
        Farm farm = new Farm();

        Assert.assertNotEquals(false, cropDuster.operate(farm));
    }

    @Test
    public void testFertilize() {
        CropRow cropRow = new CropRow();

        Assert.assertTrue(cropDuster.fertilize(cropRow));
    }

    @Test
    public void testFertilize2() {
        CropRow<Crop> cropRow = new CropRow<>();
        cropRow.add(new CornStalk());
        cropRow.add(new TomatoPlant());

        cropDuster.fertilize(cropRow);
        for (Crop c: cropRow) {
            Assert.assertTrue(c.isFertilized);
        }

    }

}