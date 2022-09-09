<script>

const API_URL = 'http://localhost:8080/products/'

export default {
    data() {
        return {
            product: {}
        }
    },

    created() {
        this.getData()
    },

    methods: {
        async getData() {
            const url = API_URL + this.$route.params.id
            const resp = await fetch(url)
            this.product = await resp.json()
        }
    }
}

</script>

<template>
    <h2> {{ this.product.title }} </h2>
    <div class="data">
        <p>ID: {{ this.product.id}}</p>
        <p>Описание: {{ this.product.description}}</p>
        <p>Количество: {{ this.product.amount}}</p>
        <p>Цена $: <strong>{{ this.product.price}}</strong></p>
    </div>
</template>

<style>
    .data {
        font-size: 18px;
    }
</style>