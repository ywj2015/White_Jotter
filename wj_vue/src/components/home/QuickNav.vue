<template>
    <div class="quick-nav">
        <img src="../../assets/icons/icon2.png" alt="" class="monster">
        <a href="https://github.com/ywj2015/README.md" target="_blank">
            <img src="../../assets/icons/icon5.png" class="readme" alt="">
        </a> 
        <img src="../../assets/icons/icon7.png" class="spark" alt="">
        <img src="../../assets/icons/logo.png" class="logo" alt="">
    </div>
</template>

<script>
export default {
    name: 'QuickNav'
}
</script>

<style scoped>
    .quick-nav {
        width: 303px;
        height: 318px;
        background-color: transparent;
    }

    .monster {
        width: 280px;
        height: 260px;
    }

    .readme {
        width: 300px;
        height: 285px;
        position: absolute;
        margin-left: 50%;
        top: 300px;
        left: 250px;
    }

    .spark {
        position: absolute;
        margin-left: 50%;
        top: 100px;
        left: 20px;
    }

    .logo {
        width: 280px;
        position: absolute;
        margin-left: 50%;
        top: 50px;
        left: 240px;
    }
</style>
