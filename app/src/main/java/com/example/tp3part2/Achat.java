


package com.example.tp3part2;
public class Achat {
        private String item;
        private double qte;

        // Constructor
        public Achat(String item, double qte) {
            this.item = item;
            this.qte = qte;
        }

        // Getter and Setter for 'item'
        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        // Getter and Setter for 'qte'
        public double getQte() {
            return qte;
        }

        public void setQte(double qte) {
            this.qte = qte;
        }
    }


