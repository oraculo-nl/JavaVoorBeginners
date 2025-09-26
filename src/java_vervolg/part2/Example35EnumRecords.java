package java_vervolg.part2;

public class Example35EnumRecords {

    //Zonder record (ouderwetse manier)
    enum ValutaOld {
        EURO("€", "EUR"),
        DOLLAR("$", "USD");

        private final String symbool;
        private final String code;

        ValutaOld(String symbool, String code) {
            this.symbool = symbool;
            this.code = code;
        }

        public String symbool() {
            return symbool;
        }

        public String code() {
            return code;
        }
    }

//Met record (mooier en compacter)
    record ValutaInfo(String symbool, String code) {
    }

    enum Valuta {
        EURO(new ValutaInfo("€", "EUR")),
        DOLLAR(new ValutaInfo("$", "USD"));

        private final ValutaInfo info;

        Valuta(ValutaInfo info) {
            this.info = info;
        }

        public ValutaInfo info() {
            return info;
        }
    }

    public static void main(String[] args) {
        System.out.println(ValutaOld.EURO.code());   // ValutaInfo[symbool=€, code=EUR]
        System.out.println(ValutaOld.DOLLAR.symbool()); // $
        System.out.println(Valuta.EURO.info());   // ValutaInfo[symbool=€, code=EUR]
        System.out.println(Valuta.DOLLAR.info().symbool()); // $
    }
}


