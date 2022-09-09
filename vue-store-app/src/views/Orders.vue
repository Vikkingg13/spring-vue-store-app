<script>
import { remove } from '@vue/shared'
import axios from 'axios'
import { watch } from 'vue'

const API_URL = 'http://localhost:8080/orders/'

export default {
    data() {
        return {
            orders: null
        }
    },

    created() {
        this.getData()
    },

    methods: {
        async getData() {
            axios.get(API_URL)
            .then(res => this.orders = res.data)
        },

        show(id) {
            this.$router.push('/order/' + id)
        },

        edit(id) {
            this.$router.push('/order/edit/' + id)
        },

        remove(id) {
            const url = API_URL + id
            axios.delete(url)
            .then(res => this.orders = res.data)
        }
    }
}
</script>

<template>
    <h2>Заказы</h2>
    <div>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Имя покупателя</th>
                    <th>Телефон покупателя</th>
                    <th>Статус заказа</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody v-for="order in orders">
            <tr>
                <td>{{ order.id }}</td>
                <td>{{ order.customerName }}</td>
                <td>{{ order.customerPhone }}</td>
                <td>{{ order.status }}</td>
                <td><button @click="show(order.id)">Показать</button></td>
                <td><button @click="edit(order.id)">Редактировать</button></td>
                <td><button @click="remove(order.id)">Удалить</button></td>
            </tr>
        </tbody>
        </table>
    </div>
</template>

<style>
    div {
    font-family: 'helvetica neue', helvetica, arial, sans-serif;
    color: rgb(31, 31, 34);
}
</style>

