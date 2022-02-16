import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPlayground {
    public static void main(String[] args) {
        System.out.println("Hello, Java");
        System.out.println(Person.N_EYES);
        System.out.println(Person.test());

        List<String> res = getTableColumns("dl_kstp.cps_main_journal_g1");
        System.out.println("res="+res);

        //
        String str = "ournal_g1 (`id_const_txt`      string      comment'ентифик`атор записи (статический, текстовый)'\n" +
                "     ,`_tech_exec_job_id`      string      comment'Id запуска (RLS_ID)'\n" +
                "     ,`_tech_load_dt`      timestamp      comment'Дата загрузки'";
        String regExp = "(?:\\(|,)`([^\\s]+)`";


        Pattern p2 = Pattern.compile(regExp);
        Matcher m2 = p2.matcher(str);
        if (m2.find()) {
            String output = m2.replaceAll("$1");
            System.out.println("output2="+output);
        }
        List<String> fields = new ArrayList<>();
        while(m2.find()) {
            fields.add(m2.group(1));
        }
        System.out.println("fields="+fields);
    }

    public static void main(String[] args, String[] args2) {}

    public static List<String> getTableColumns(String table) {
        final String Ddl = "drop table if exists dl_kstp.cps_main_journal_g1;\n" +
                "create table if not exists dl_kstp.cps_main_journal_g1 (`id_const_txt`      string      comment'ентификатор записи (статический, текстовый)'\n" +
                "     ,`_tech_exec_job_id`      string      comment'Id запуска (RLS_ID)'\n" +
                "     ,`_tech_load_dt`      timestamp      comment'Дата загрузки'\n" +
                "     ,`analyze_config_id`      decimal(38)      comment'ID конфигурации анализа'\n" +
                "     ,`analyze_config_name`      string      comment'Наименование конфигурации анализа'\n" +
                "     ,`code_no`      string      comment'Код НО'\n" +
                "     ,`context_business_object`      string      comment'Контекст бизнес-объекта'\n" +
                "     ,`context_event`      string      comment'Контекст события'\n" +
                "     ,`context_inspector`      string      comment'Контекст исполнителя'\n" +
                "     ,`create_date`      timestamp      comment'Дата создания записи'\n" +
                "     ,`doc_type_name`      string      comment'Наименование типа документа'\n" +
                "     ,`document_id`      string      comment'ID документа'\n" +
                "     ,`document_load_date`      date      comment'Дата загрузки документа'\n" +
                "     ,`event_date`      timestamp      comment'Дата события'\n" +
                "     ,`event_position`      decimal(38)      comment'Порядковый номер КА в ВП'\n" +
                "     ,`event_rec_id`      decimal(38)      comment'ентификатор записи цифрового следа'\n" +
                "     ,`event_type_id`      decimal(38)      comment'ID типа события'\n" +
                "     ,`event_type_name`      string      comment'Наименование типа события'\n" +
                "     ,`executor_id`      string      comment'ID исполнителя'\n" +
                "     ,`extension`      string      comment'Дополнительные сведения'\n" +
                "     ,`id`      decimal(38)      comment'ентификатор записи'\n" +
                "     ,`instance_id`      string      comment'ID экземпляра восстанавливаемого процесса'\n" +
                "     ,`is_first_event`      boolean      comment'Является стартовым событием'\n" +
                "     ,`is_last_event`      boolean      comment'Является завершающим событием'\n" +
                "     ,`region_code`      string      comment'Код региона'\n" +
                "     ,`restorable_process_id`      decimal(38)      comment'ID восстанавливаемого процесса'\n" +
                "     ,`restorable_process_name`      string      comment'Наименование восстанавливаемого процесса'\n" +
                "     ,`subsystem`      string      comment'Подсистема'\n" +
                "     ,`version`      decimal(38)      comment'Версия скрипта')stored as orc";

        final Pattern p = Pattern.compile("(?:\\(|,)`([^\\s]+)`");
        final Matcher m = p.matcher(Ddl);

        List<String> fields = new ArrayList<>();

        if (m.find()) {
            String output = m.replaceAll("$2");
            System.out.println("output2="+output);
        }

        while (m.find()) {
            fields.add(m.group(1));
        }

        return fields;


    }
}

class Person {
    public static final int N_EYES = 2;
    public static String test() {
        return "test";
    }
}
