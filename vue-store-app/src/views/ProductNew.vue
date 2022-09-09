<script>

import ProductForm from '@/components/ProductForm.vue'
import axios from 'axios';

const API_URL = 'http://localhost:8080/products'

export default {
    
    methods: {
        submit(product) {
            axios.post(API_URL, product)
            this.clearForm(product)
        },

        clearForm(product) {
            product.title = product.description = ""
            product.amount = product.price = ""
        }
    },
    components: { ProductForm }
}
</script>

<template>
    <ProductForm 
        title="Новый продукт"
        @submit-form="submit"
    ></ProductForm> 
</template>