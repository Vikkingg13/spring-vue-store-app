
<script>
export default {
    props : {
        saved : Boolean
    }
}

</script>

<template>
    <strong class="label"><slot></slot></strong>
</template>

<style>
    .label {
        font: small-caps bold 14px sans-serif;
        color: darkgreen;
    }
</style>