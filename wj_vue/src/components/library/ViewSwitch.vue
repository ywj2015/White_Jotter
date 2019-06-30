<template>
    <div>
        <el-switch v-model="value"
            active-text="列表视图"></el-switch>
    </div>
</template>

<script>
export default {
    name: 'Switch',
    data() {
        return {
            value: true
        }
    },
}
</script>

<style scoped>

</style>
