package net.minecraft.util;

public class Tuple<A, B> {
   private A a;
   private B b;

   public Tuple(A p_i1555_1_, B p_i1555_2_) {
      this.a = p_i1555_1_;
      this.b = p_i1555_2_;
   }

   public A getA() {
      return this.a;
   }

   public B getB() {
      return this.b;
   }
}