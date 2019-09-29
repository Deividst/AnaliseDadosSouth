package com.southsystem.analisedados.converter;

import com.southsystem.analisedados.model.Client;
import com.southsystem.analisedados.model.Item;
import com.southsystem.analisedados.model.Sale;
import com.southsystem.analisedados.model.Salesman;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Deivid
 */
public class ConvertersTests {


    @Test
    public void shouldConvertToClient(){
        String[] atributos = {"002", "2345675434544345", "Jose da Silva", "Rural"};

        Client client = ClientConverter.converter(atributos);

        Assert.assertNotNull(client);
    }

    @Test
    public void shouldConvertToSalesman(){
        String[] atributos = {"001", "1234567891234", "Pedro", "500000"};

        Salesman salesman = SalesmanConverter.converter(atributos);

        Assert.assertNotNull(salesman);
    }

    @Test
    public void shouldConvertToSale(){
        String[] atributos = {"003", "10", "[1-10-100,2-30-2.50,3-40-3.10]", "Pedro"};

        Sale sale = SaleConverter.converter(atributos);

        Assert.assertNotNull(sale);
    }

    @Test
    public void shouldConvertToItem(){
        String atributos = "1-10-100";

        Item item = ItemConverter.converter(atributos);

        Assert.assertNotNull(item);
    }

}
