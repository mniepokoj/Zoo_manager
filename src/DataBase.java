import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.lang.Object.*;
import java.util.Arrays;
import java.util.Collection;

public class DataBase
{
    boolean status = false;
    Connection c = null;
    Model_object data;


    private static String success_statment = "Polecenie przetworzone pomyślnie";
    private static String error_statment = "Polecenie nie zostało zrealizowane";
    private static String invalid_data_statment = "Podane dane są nie prawidłowe";
    private static String not_fount_statment = "Nie znaleziono żadnego  rekordu";

    public DataBase(Model_object DATA)
    {
        data = DATA;
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
                try
                {

                    String url = "jdbc:postgresql://abul.db.elephantsql.com:5432/pvguekha";
                    String user = "pvguekha";
                    String password = "Uha-z5zrqN9j47lTdnkVfD5XADxdVkwd";
                    c = DriverManager.getConnection( url, user, password);
                    status = true;
                    data.getCenterPane().setOut("Udało się połączyć z bazą danych");

                } catch (SQLException se)
                {
                    data.getCenterPane().setOut("Nie udało się połączyć z bazą danych");
                }

    }

    private int get_result_set_size(ResultSet resultSet)
    {
        int size = 0;
        try {
            resultSet.last();
            size = resultSet.getRow();
            resultSet.beforeFirst();
        }
        catch(Exception ex) {
            return 0;
        }
        return size;
    }


    void getTable(String table_name, ArrayList<String> Column, ArrayList<ArrayList<String>> Data)
    {
            try
            {
                String query_string = "SELECT * FROM zoo."+table_name+";";
                PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = pst.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int column_size = rsmd.getColumnCount();
                int row_size = get_result_set_size(rs);
                for(int i = 0; i < column_size; i++)
                {
                    Column.add(rsmd.getColumnLabel(i+1));
                }

                for(int i = 0; i < row_size; i++)
                {
                    rs.next();
                    Data.add(new ArrayList());
                    for( int j = 0; j < column_size; j++)
                    {
                        Data.get(i).add(rs.getString(j+1));
                    }
                }
                rs.close();
                pst.close();
                if(row_size == 0)
                {
                    data.getCenterPane().setOut(not_fount_statment);
                }
                else
                {
                    data.getCenterPane().setOut(success_statment);
                }
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }

    void getZwierzeta( ArrayList<String> Column, ArrayList<ArrayList<String>> Data)
    {
        getTable("zwierzeta", Column, Data);
    }


    void getPopularneZwierzeta(ArrayList<String> Column, ArrayList<ArrayList<String>> Data)
    {
        getTable("popularne_zwierzeta", Column, Data);
    }


    void addGatunek(String nazwa, String typ, String pasza)
    {
        try
        {
            String query_string = "SELECT Id_pasza, opis FROM zoo.Pasza";

            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();

            int row_size = get_result_set_size(rs);
            int id_pasza = -1;
            for(int i = 0; i < row_size; i++) {
                rs.next();
                if (rs.getString(2).equals(pasza))
                {
                    id_pasza = rs.getInt(1);
                    break;
                }
            }
            if(id_pasza == -1)
            {
                throw new SQLException();
            }
            rs.close();
            pst.close();

            Statement statement = c.createStatement();
            statement.executeUpdate("INSERT INTO zoo.Gatunek VALUES (DEFAULT, '"+ nazwa +"','"+typ+"',"+id_pasza+");");
            statement.close();


            data.getCenterPane().setOut(success_statment);
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }

    void addZwierze(String imie, String gatunek, String plec, String date)
    {
        try
        {
            String query_string;

            PreparedStatement pst;
            ResultSet rs;

            query_string = "SELECT id_gatunek FROM zoo.gatunek WHERE gatunek.nazwa = '" + gatunek + "';";
            int id_gatunek = -1;
            pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            if(rs.next())
            {
                id_gatunek = rs.getInt(1);
            }
            else
                throw new SQLException();

            String plec_val = (plec.compareTo("Samiec") == 0 || plec.compareTo("M") == 0) ? "true" : "false";

            Statement statement = c.createStatement();
            statement.executeUpdate("INSERT INTO zoo.Zwierze VALUES (DEFAULT, '"+ imie +"',"+id_gatunek+",'"+date+"', " + plec_val + ");");
            statement.close();


            data.getCenterPane().setOut(success_statment);
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }


    void getPracownicy(ArrayList<String> Column, ArrayList<ArrayList<String>> Data)
    {
        try
        {
            String query_string = "SELECT * FROM zoo.pracownicy;";
            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int column_size = rsmd.getColumnCount();
            int row_size = get_result_set_size(rs);
            for(int i = 0; i < column_size; i++)
            {
                Column.add(rsmd.getColumnLabel(i+1));
            }

            for(int i = 0; i < row_size; i++)
            {
                rs.next();
                Data.add(new ArrayList());
                for( int j = 0; j < column_size; j++)
                {
                    Data.get(i).add(rs.getString(j+1));
                }
            }
            rs.close();
            pst.close();
            if(row_size == 0)
            {
                data.getCenterPane().setOut(not_fount_statment);
            }
            else
            {
                data.getCenterPane().setOut(success_statment);
            }
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }


    void addPracownik(String imie, String nazwisko, String stanowisko, String numer_telefonu, String data_zatrudnienia, String id_kierownik)
    {
        try
        {
            String query_string;

            PreparedStatement pst;
            ResultSet rs;

            Statement statement = c.createStatement();
            statement.executeUpdate("INSERT INTO zoo."+ stanowisko +" VALUES " +
                    "(DEFAULT, '"+ nazwisko +"','"+imie+"',"+numer_telefonu+", '" +data_zatrudnienia +
                    "', "+id_kierownik  + ");");
            statement.close();


            data.getCenterPane().setOut(success_statment);
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }

    String[] getNazwiskoKierwonik()
    {
        ArrayList<String> s = new ArrayList<String>();
        try
        {
            String query_string =  "SELECT nazwisko from zoo.kierownik;";
            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();


            while(rs.next())
            {
                s.add(rs.getString(1));
            }
            rs.close();
            pst.close();
        }
        catch(SQLException e)
        {
            System.out.println(error_statment);
        }
        String[] stringArray = Arrays.copyOf(s.toArray(), s.toArray().length, String[].class);
        return stringArray;
    }

    String[] getPasza()
    {
        ArrayList<String> s = new ArrayList<String>();
        try
        {
            String query_string =  "SELECT opis from zoo.Pasza;";
            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();


            while(rs.next())
            {
                s.add(rs.getString(1));
            }
            rs.close();
            pst.close();
        }
        catch(SQLException e)
        {
            System.out.println(error_statment);
        }
        String[] stringArray = Arrays.copyOf(s.toArray(), s.toArray().length, String[].class);
        return stringArray;
    }


    String[] getGatunek()
    {
        ArrayList<String> s = new ArrayList<String>();
        try
        {
            String query_string =  "SELECT nazwa from zoo.Gatunek;";
            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();


            while(rs.next())
            {
                s.add(rs.getString(1));
            }
            rs.close();
            pst.close();
        }
        catch(SQLException e)
        {
            System.out.println(error_statment);
        }
        String[] stringArray = Arrays.copyOf(s.toArray(), s.toArray().length, String[].class);
        return stringArray;
    }


    void getMagazynier(String pokarm, ArrayList<String> Column, ArrayList<ArrayList<String>> Data)
    {
        try
        {
            String query_string = "Select imie, nazwisko, numer_telefonu, data_zatrudnienia FROM zoo.magazynier " +
                    "JOIN zoo.Pasza ON Pasza.id_magazynier = magazynier.id_magazynier WHERE pasza.opis = '" + pokarm + "';";

            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int column_size = rsmd.getColumnCount();
            int row_size = get_result_set_size(rs);

            Column.add("Imie");
            Column.add("Nazwisko");
            Column.add("Numer telefonu");
            Column.add("Data zatrudnienia");

            for(int i = 0; i < row_size; i++)
            {
                rs.next();
                Data.add(new ArrayList());
                for(int j = 0; j < column_size; j++) {
                    Data.get(i).add(rs.getString(j+1));
                }
            }
            rs.close();
            pst.close();


            if(Data.size() == 0)
            {
                data.getCenterPane().setOut(not_fount_statment);
            }
            else
            {
                data.getCenterPane().setOut(success_statment);
            }

        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }

    void getPracownicyKierownik(String nazwisko_kierownika,ArrayList<String> Column, ArrayList<ArrayList<String>> Data)
    {
        try
        {
            String query_string = "Select opiekun.imie, opiekun.nazwisko, opiekun.numer_telefonu, opiekun.data_zatrudnienia " +
                    "FROM zoo.opiekun JOIN zoo.kierownik ON kierownik.id_kierownik = opiekun.id_kierownik " +
                    "WHERE kierownik.nazwisko = '"+ nazwisko_kierownika +"';";

            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int column_size = rsmd.getColumnCount();
            int row_size = get_result_set_size(rs);

            Column.add("Imie");
            Column.add("Nazwisko");
            Column.add("Numer telefonu");
            Column.add("Data zatrudnienia");
            Column.add("Typ");

            for(int i = 0; i < row_size; i++)
            {
                rs.next();
                Data.add(new ArrayList());
                for(int j = 0; j < column_size; j++) {
                    Data.get(i).add(rs.getString(j+1));
                }
                Data.get(Data.size()-1).add("Opiekun");
            }
            rs.close();
            pst.close();


            query_string = "Select magazynier.imie, magazynier.nazwisko, magazynier.numer_telefonu, magazynier.data_zatrudnienia " +
                    "FROM zoo.magazynier JOIN zoo.kierownik ON magazynier.id_kierownik = kierownik.id_kierownik " +
                    "WHERE kierownik.nazwisko = '"+ nazwisko_kierownika +"';";

            pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();

            row_size = get_result_set_size(rs);

            for(int i = 0; i < row_size; i++)
            {
                rs.next();
                Data.add(new ArrayList());
                for(int j = 0; j < column_size; j++) {
                    Data.get(Data.size()-1).add(rs.getString(j+1));
                }
                Data.get(Data.size()-1).add("Magazynier");
            }
            rs.close();
            pst.close();


            query_string = "Select kasjer.imie, kasjer.nazwisko, kasjer.numer_telefonu, kasjer.data_zatrudnienia " +
                    "FROM zoo.kasjer JOIN zoo.kierownik ON kasjer.id_kierownik = kierownik.id_kierownik " +
                    "WHERE kierownik.nazwisko = '"+ nazwisko_kierownika +"';";

            pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();

            row_size = get_result_set_size(rs);

            for(int i = 0; i < row_size; i++)
            {
                rs.next();
                Data.add(new ArrayList());
                for(int j = 0; j < column_size; j++) {
                    Data.get(Data.size()-1).add(rs.getString(j+1));
                }
                Data.get(Data.size()-1).add("Kasjer");
            }
            rs.close();
            pst.close();


            if(Data.size() == 0)
            {
                data.getCenterPane().setOut(not_fount_statment);
            }
            else
            {
                data.getCenterPane().setOut(success_statment);
            }

        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }


    private void insert_table(String query)
    {
        try
        {
            String query_string;
            PreparedStatement pst;
            ResultSet rs;
            Statement statement = c.createStatement();
            statement.executeUpdate(query);
            statement.close();
            data.getCenterPane().setOut(success_statment);
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }
    }


    private static boolean parse_number(String strNum)
    {
        if (strNum == null) {
            return true;
        }
        if(strNum.equals("DEFAULT") || strNum.equals("default"))
        {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }


    void insert_opiekun(String id_opiekun, String imie, String nazwisko, String numer_telefonu, String data_zatrudnienia, String id_kierownik, String login, String haslo)
    {
        if(parse_number(id_opiekun) || parse_number(numer_telefonu) || parse_number(id_kierownik) )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }

        String query = String.format("INSERT INTO Zoo.Opiekun VALUES (%s,'%s', '%s', %s, '%s', %s,'%s', '%s');",
                id_opiekun, imie, nazwisko, numer_telefonu, data_zatrudnienia, id_kierownik, login, haslo );
        insert_table(query);
    }

    void insert_zwierze(String id_zwierze, String imie, String Id_gatunek, String data_urodzenia, String Samiec)
    {
        if(parse_number(id_zwierze) || parse_number(Id_gatunek)  )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Zwierze VALUES (%s, '%s',%s, '%s', %s);", id_zwierze, imie, Id_gatunek, data_urodzenia, Samiec );
        insert_table(query);
    }

    void insert_opiekun_zwierze(String id_zwierze, String id_opiekun)
    {
        if(parse_number(id_zwierze) || parse_number(id_opiekun)  )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Opiekun_Zwierze(Id_zwierze, Id_opiekun) VALUES (%s, %s);", id_zwierze, id_opiekun );
        insert_table(query);
    }

    void insert_gatunek(String id_gatunek, String Nazwa, String Typ, String id_pasza)
    {
        if(parse_number(id_gatunek) || parse_number(id_pasza)  )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Gatunek VALUES (%s, '%s', '%s', %s);", id_gatunek, Nazwa, Typ, id_pasza );
        insert_table(query);
    }

    void insert_pasza(String id_pasza, String opis, String id_magazynier)
    {
        if(parse_number(id_pasza) || parse_number(id_magazynier)  )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Pasza VALUES (%s, '%s', %s );",id_pasza, opis, id_magazynier );
        insert_table(query);
    }

    void insert_magazynier(String id_opiekun, String imie, String nazwisko, String numer_telefonu, String data_zatrudnienia, String id_kierownik, String login, String haslo)
    {
        if(parse_number(id_opiekun) || parse_number(numer_telefonu) || parse_number(id_kierownik) )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Magazynier VALUES (%s,'%s', '%s', %s, '%s', %s,'%s', '%s');",
                id_opiekun, imie, nazwisko, numer_telefonu, data_zatrudnienia, id_kierownik, login, haslo );
        insert_table(query);
    }

    void insert_kierownik(String id_opiekun, String imie, String nazwisko, String numer_telefonu, String data_zatrudnienia, String login, String haslo)
    {
        if(parse_number(id_opiekun) || parse_number(numer_telefonu) )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Kierownik VALUES (%s,'%s', '%s', %s, '%s' );",
                id_opiekun, imie, nazwisko, numer_telefonu, data_zatrudnienia, login, haslo);
        insert_table(query);
    }

    void insert_ankieta(String Ankieta_id, String id_ulubione_zwierze)
    {
        if(parse_number(Ankieta_id) || parse_number(id_ulubione_zwierze) )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Ankieta VALUES(%s, %s);",Ankieta_id, id_ulubione_zwierze );
        insert_table(query);
    }

    void insert_kasjer(String id_opiekun, String imie, String nazwisko, String numer_telefonu, String data_zatrudnienia, String id_kierownik, String login, String haslo)
    {
        if(parse_number(id_opiekun) || parse_number(numer_telefonu) || parse_number(id_kierownik) )
        {
            data.getCenterPane().setOut(invalid_data_statment);
            return;
        }
        String query = String.format("INSERT INTO Zoo.Kasjer VALUES (%s,'%s', '%s', %s, '%s', %s, '%s', '%s' );",
                id_opiekun, imie, nazwisko, numer_telefonu, data_zatrudnienia, id_kierownik, login, haslo );
        insert_table(query);
    }

    String get_pasza_id(String pasza)
    {
        try
        {
            String query_string = "Select id_pasza FROM zoo.pasza WHERE pasza.opis = '"+pasza+"';";

            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String r = rs.getString(1);
            rs.close();
            pst.close();
            return r;
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }

        return "0";
    }


    void dodaj_gatunek(String nazwa, String typ, String pasza)
    {
        String id_pasza = get_pasza_id(pasza);
        insert_gatunek("DEFAULT", nazwa, typ, id_pasza);
    }


    String get_gatunek_id(String gatunek)
    {
        try
        {
            String query_string = "Select id_gatunek FROM zoo.gatunek WHERE gatunek.nazwa = '"+gatunek+"';";

            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String r = rs.getString(1);
            rs.close();
            pst.close();
            return r;
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }

        return "0";
    }

    void dodaj_zwierze(String imie, String data_urodzenia, String samiec, String gatunek)
    {
        String id_gatunek = get_gatunek_id(gatunek);
        insert_zwierze("DEFAULT", imie, id_gatunek, data_urodzenia, samiec);
    }

    int login(String user, String pass)
    {
        try
        {
            String query_string = String.format("SELECT * FROM zoo.kierownik where kierownik.login='%s' AND haslo='%s';", user, pass);

            PreparedStatement pst = c.prepareStatement(query_string, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            int r = get_result_set_size(rs);
            rs.close();
            pst.close();
            return r;
        }
        catch(SQLException e)
        {
            data.getCenterPane().setOut(error_statment);
        }

        return 0;
    }
}