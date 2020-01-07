package day09;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class Dbutils {
    private static QueryRunner queryRunner = null;
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    public Dbutils() {
    }

    public static QueryRunner getQueryRunner() {
        queryRunner = new QueryRunner(comboPooledDataSource);
        return queryRunner;
    }
}
