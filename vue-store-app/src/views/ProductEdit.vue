<script>
import ProductForm from '@/components/ProductForm.vue'

import axios from 'axios';

const API_URL = 'http://localhost:8080/products/'

export default {
    data() {
        return {
            productReady : false,
            product : null,
        }
    },

    created() {
        this.getData()
    },

    methods: {
        getData() {
            const url = API_URL + this.$route.params.id
            axios.get(url)
            .then(res => {
                this.product = res.data
                this.productReady = true
            })
            .catch(error => console.log(error))
        },

        submit(product) {
            const url = API_URL + this.$route.params.id
            axios.put(url, product)
            .then(res => console.log(res))
            .catch(error => console.log(error))
        }
    },

    components: { ProductForm }
}
</script>

<template>
        <ProductForm v-if="product"
            title="Редактировать продукт"
            :initProduct="product"
            @submit-form="submit"
        ></ProductForm>
</template>