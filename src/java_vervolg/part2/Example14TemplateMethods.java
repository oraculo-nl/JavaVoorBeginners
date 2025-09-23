package java_vervolg.part2;

public class Example14TemplateMethods {
    static abstract class Meal {
        // template method (het stappenplan)
        public final void prepareMeal() {
            cookMain();
            addSideDish();
            serve();
        }

        // vaste stap
        private void serve() {
            System.out.println("Serve the meal on a plate");
        }

        // extensiepunten (subclasses bepalen de invulling)
        protected abstract void cookMain();

        protected abstract void addSideDish();
    }

    static class PastaMeal extends Meal {
        @Override
        protected void cookMain() {
            System.out.println("Cook pasta with tomato sauce");
        }

        @Override
        protected void addSideDish() {
            System.out.println("Add garlic bread");
        }
    }

    static class CurryMeal extends Meal {
        @Override
        protected void cookMain() {
            System.out.println("Cook chicken curry");
        }

        @Override
        protected void addSideDish() {
            System.out.println("Add rice");
        }
    }

    public static void main(String[] args) {
        Meal m1 = new PastaMeal();
        Meal m2 = new CurryMeal();

        m1.prepareMeal();
        System.out.println();
        m2.prepareMeal();
    }
}

