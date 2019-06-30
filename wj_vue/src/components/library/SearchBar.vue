<template>
    <div style="margin-bottom: 30px;display: flex;justify-content: center;align-items: center;">
        <el-input @keyup.enter.native="searchClick"
            v-model="keywords" 
            size="small"
            prefix-icon="el-icon-search"
            style="width: 400px;margin-right: 10px;"
            placeholder="通过书名或作者搜索..."></el-input>
            <el-button type="primary" size="small" icon="el-icon-search" @click="searchClick">搜索</el-button>
    </div>
</template>

<script>
export default {
    name: 'SearchBar',
    data() {
        return {
            keywords: '',
            books: [],
            cardLoading: ''
        }
    },
    methods: {
        searchClick() {
            this.$emit("onSearch")
        }
    }
}
</script>

<style scoped>

</style>
