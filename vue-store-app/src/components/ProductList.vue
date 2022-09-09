<script>

export default {

props: {
    showButton : Boolean,
    editButton : Boolean,
    removeButton : Boolean,
    products : Array
},

emits: ['show-product', 'edit-product', 'remove-product']

}
</script>

<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Название</th>
                    <th>Количество</th>
                    <th>Цена/шт.</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody v-for="product in products">
                <tr>
                    <td>{{ product.id }}</td>
                    <td>{{ product.title }}</td>
                    <td>{{ product.amount }}</td>
                    <td>{{ product.price }}</td>
                    <td><button v-if="showButton" @click="$emit('show-product', product.id)">Показать</button></td>
                    <td><button v-if="editButton" @click="$emit('edit-product', product.id)">Редактировать</button></td>
                    <td><button v-if="removeButton" @click="$emit('remove-product', product.id)">Удалить</button></td>
                </tr>
            </tbody>
    </table>
</div>
</template>