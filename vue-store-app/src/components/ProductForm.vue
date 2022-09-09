<script>
import CustomLabel from './UI/CustomLabel.vue';

export default {
    props: {
        title: String,
        initProduct: {
            type : Object,
            default() {
                return {
                    title : "",
                    description : "",
                    amount : "",
                    price : ""
                }
            }
        }
    },

    data() {
        return {
            product : null,
            isSaved : false
        }
    },

    created() {
        this.product = this.initProduct
    },

    methods: {
        isEmpty(product) {
            let emptyProduct = {
                    title : "",
                    description : "",
                    amount : "",
                    price : "" 
                }
            return (JSON.stringify(product) == JSON.stringify(emptyProduct))
        }
    },

    watch: {
        product: {
            handler(newProduct) {
                if (this.isSaved && !this.isEmpty(newProduct)) {
                    this.isSaved = false
                }
            },
            deep: true
        }
    }, 

    emits: ["submit-form"],

    components: { CustomLabel }
}
</script>

<template>
    <h2>{{ title }}</h2>
    <div>
        <p><input v-model="product.title" type="text" placeholder="Название"/></p>
        <p><input v-model="product.description" type="text" placeholder="Описание"/></p>
        <p><input v-model="product.amount" type="number" placeholder="Количество"/></p>
        <p><input v-model="product.price" type="number"  placeholder="Цена"/></p>
    </div>
    <div>
        <button @click="isSaved = true, $emit('submit-form', product)">Сохранить</button>
        <CustomLabel v-if="isSaved"> Сохранено </CustomLabel>
    </div>
</template>

<style>
    div {
        font-family: 'helvetica neue', helvetica, arial, sans-serif;
        color: rgb(31, 31, 34);
    }

    table {
        align-content: center;
        align-items: center;

        table-layout: fixed;
        border-collapse: collapse;

        margin-top: 20px;
    }

    thead {
        background-color: rgb(150, 150, 255);
    }

    th, td {
        padding: 10px;
    }
    </style>