package com.kristina_head.nutrinfo.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"fat", "carbohydrate", "protein", "unit"})
public class Macronutrients {
    private static final String UNIT = "g";
    private Long foodId;
    private Fat fat;
    private Carbohydrate carbohydrate;
    private float protein;

    @JsonPropertyOrder({"totalFat", "saturatedFat", "polyunsaturatedFat", "monounsaturatedFat", "cholesterol"})
    public static class Fat {
        private float saturatedFat;
        private float polyunsaturatedFat;
        private float monounsaturatedFat;
        private float cholesterol;

        public Fat(float saturatedFat, float polyunsaturatedFat, float monounsaturatedFat, float cholesterol) {
            this.saturatedFat = saturatedFat;
            this.polyunsaturatedFat = polyunsaturatedFat;
            this.monounsaturatedFat = monounsaturatedFat;
            this.cholesterol = cholesterol;
        }

        public float getTotalFat() {
            return this.saturatedFat + this.polyunsaturatedFat + this.monounsaturatedFat + this.cholesterol;
        }

        public float getSaturatedFat() {
            return this.saturatedFat;
        }

        public float getPolyunsaturatedFat() {
            return this.polyunsaturatedFat;
        }

        public float getMonounsaturatedFat() {
            return this.monounsaturatedFat;
        }

        public float getCholesterol() {
            return this.cholesterol;
        }
    }

    @JsonPropertyOrder({"totalCarbohydrate", "fiber", "sugar"})
    public static class Carbohydrate {
        private float fiber;
        private float sugar;

        public Carbohydrate(float fiber, float sugar) {
            this.fiber = fiber;
            this.sugar = sugar;
        }

        public float getTotalCarbohydrate() {
            return this.fiber + this.sugar;
        }

        public float getFiber() {
            return this.fiber;
        }

        public float getSugar() {
            return this.sugar;
        }
    }

    public Macronutrients(Long foodId, Fat fat, Carbohydrate carbohydrate, float protein) {
        this.foodId = foodId;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
    }

    @JsonIgnore
    public Long getFoodId() {
        return this.foodId;
    }

    public Fat getFat() {
        return this.fat;
    }

    public Carbohydrate getCarbohydrate() {
        return this.carbohydrate;
    }

    public float getProtein() {
        return this.protein;
    }

    public String getUNIT() {
        return UNIT;
    }
}
