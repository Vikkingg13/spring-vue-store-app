<script>

import axios from "axios"

import ProductList from '@/components/ProductList.vue'

const API_URL = 'http://localhost:8080/products/'

export default {
    data() {
        return {
            products: []
        }
    },

    created() {
        this.getData();
    },

    methods: {
        getData() {
            axios.get(API_URL)
            .then(res => this.products = res.data)
        },
        create() {
            this.$router.push("/product/new");
        },

        show(id) {
            this.$router.push("/product/" + id);
        },

        edit(id) {
            this.$router.push("/product/edit/" + id);
        },

        remove(id) {
            const url = API_URL + id;
            axios.delete(url)
            .then(res => this.products = res.data)
        }
    },
    components: { ProductList }
}
</script>

<template>
    <h2>Товары</h2>
    <button @click="create()">Новый товар</button>
    <ProductList
        :products="products"
        showButton
        editButton
        removeButton
        @show-product="show"
        @edit-product="edit"
        @remove-product="remove"
    ></ProductList>
</template>